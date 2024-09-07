package fpc.aoc.year2019.day18._private.algo;

import fpc.aoc.common.Table;
import fpc.aoc.year2019.day18._private.Key;
import fpc.aoc.year2019.day18._private.Keyring;
import fpc.aoc.year2019.day18._private.Maze;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Bastien Aracil
 **/
public class KeyCollector {


    public static int collectAll(@NonNull Maze maze) {
        return new KeyCollector(maze).collectAll();
    }

    @NonNull
    private final Key[] startingKeys;

    @NonNull
    private final Graph graph;

    private final int nbRobots;

    @NonNull
    private final Keyring keyring;

    @NonNull
    private final Table<Long,Long,Integer> history;

    private int shortest = -1;

    private final Stack stack;

    public KeyCollector(@NonNull Maze maze) {
        this.startingKeys = maze.startingKeys().toArray(Key[]::new);
        this.nbRobots = startingKeys.length;
        this.graph = new Graph(maze);

        final var allKeys = maze.allKeys();
        this.keyring = new Keyring(allKeys);
        this.history = Table.create();
        this.stack = new Stack(allKeys.size());
    }

    private int collectAll() {
        this.shortest = -1;
        this.history.clear();
        this.keyring.reset();
        this.stack.initialize();

        this.recurse();

        return shortest;
    }

    private void recurse() {
        if (isCurrentLongerThanShortestSoFar() || isCurrentLongerThanSimilarTripInHistory()) {
            return;
        }
        addCurrentKeyToKeyring();
        try {
            updateHistory();
            if (keyring.isComplete()) {
                setShortestToCurrentLength();
                return;
            }

            final List<RouteWithRobotIndex> routes = findTravelableRoutesToAllMissingKeys();

            routes.forEach(rs -> {
                stack.push(rs);
                recurse();
                stack.pop();

            });

        } finally {
            removeCurrentKeyToKeyring();
        }
    }

    @NonNull
    private List<RouteWithRobotIndex> findTravelableRoutesToAllMissingKeys() {
        return keyring.missingKeys()
                      .map(this::findTravelableRoute)
                      .flatMap(Optional::stream)
                      .sorted(Comparator.comparingInt(RouteWithRobotIndex::length))
                      .collect(Collectors.toList());
    }

    private Optional<RouteWithRobotIndex> findTravelableRoute(@NonNull Key destination) {
        final StackItem item = stack.current();

        return IntStream.range(0, nbRobots)
                        .mapToObj(i -> graph.findTravelableRoute(item.keys[i], destination, keyring).map(r -> new RouteWithRobotIndex(i, r)))
                        .flatMap(Optional::stream)
                        .findAny();

    }



    private void setShortestToCurrentLength() {
        final StackItem item = stack.current();
        if (shortest<0 || shortest>item.length) {
            this.shortest = item.length;
        }

    }

    private void addCurrentKeyToKeyring() {
        updateKeyring(keyring::addKey);
    }

    private void removeCurrentKeyToKeyring() {
        updateKeyring(keyring::removeKey);
    }

    private void updateKeyring(Consumer<Key> updater) {
        final StackItem item = stack.current();
        item.modifiedKeys().forEach(updater);
    }


    private void updateHistory() {
        final StackItem item = stack.current();
        item.updateHistory();
    }


    private boolean isCurrentLongerThanSimilarTripInHistory() {
        final StackItem item = stack.current();
        return item.isLongerThanHistory();
    }

    private boolean isCurrentLongerThanShortestSoFar() {
        final StackItem item = stack.current();
        return shortest>=0&&item.length>=shortest;
    }

    @Override
    public String toString() {
        return shortest+" - "+keyring+" - "+stack;
    }

    @Getter
    @RequiredArgsConstructor
    private static class RouteWithRobotIndex {

        private final int robotIndex;

        @NonNull
        private final Route route;

        @Override
        public String toString() {
            return route.trip().toString();
        }

        public int length() {
            return route.length();
        }
    }

    private class Stack {

        private final StackItem[] items;

        private int size;

        public Stack(int capacity) {
            this.items = IntStream.range(0,capacity).mapToObj(i -> new StackItem()).toArray(StackItem[]::new);
            this.size = 0;
        }

        public void push(@NonNull KeyCollector.RouteWithRobotIndex routeWithRobotIndex) {
            final StackItem current = current();
            final StackItem next = items[size++];
            next.initializeWith(current,routeWithRobotIndex);
        }

        public void initialize() {
            final StackItem item = items[size++];
            System.arraycopy(startingKeys,0,item.keys,0,startingKeys.length);
            item.current = Arrays.stream(startingKeys).mapToLong(Key::mask).reduce(0, (l1,l2)-> l1 | l2);
            item.visited = 0;
            item.modifiedIndex = -1;
        }

        public void pop() {
            size--;
        }

        public StackItem current() {
            return items[size-1];
        }

        @Override
        public String toString() {
            return Arrays.stream(items,0,size)
                         .map(Object::toString)
                         .collect(Collectors.joining(", ","Stack{("+size+")","}"));
        }

    }

    private class StackItem {

        private Key[] keys;

        private int modifiedIndex;

        private long current;

        private long visited;

        private int length;


        public StackItem() {
            this.keys = new Key[nbRobots];
            this.current = 0;
            this.length = 0;
        }

        public void updateHistory() {
            history.put(current,visited,length);
        }

        public boolean isLongerThanHistory() {
            if (modifiedIndex < 0) {
                return false;
            }
            final Integer fromHistory = history.get(current,visited);
            return fromHistory != null && fromHistory <= length;
        }

        @NonNull
        public Stream<Key> modifiedKeys() {
            if (modifiedIndex<0){
                return Arrays.stream(keys);
            }
            return Stream.of(keys[modifiedIndex]);
        }

        @Override
        public String toString() {
            if (modifiedIndex<0){
                return "@";
            }
            return keys[modifiedIndex].displayedId() +"("+length+")";
        }

        public void initializeWith(StackItem source,@NonNull RouteWithRobotIndex routeWithRobotIndex) {
            final int robotIndex = routeWithRobotIndex.robotIndex();
            final Route route = routeWithRobotIndex.route();

            System.arraycopy(source.keys,0,this.keys,0,this.keys.length);
            this.keys[robotIndex] = route.destination();
            this.current = (source.current&~source.keys[robotIndex].mask())|route.destination().mask();
            this.visited = source.visited|source.keys[robotIndex].mask();
            this.length = source.length+route.length();
            this.modifiedIndex = robotIndex;
        }

    }
}
