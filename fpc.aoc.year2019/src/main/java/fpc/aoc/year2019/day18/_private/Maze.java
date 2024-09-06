package fpc.aoc.year2019.day18._private;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.BiMap;
import fpc.aoc.common.Tools;
import fpc.aoc.year2019.day18._private.algo.FastestRouteFinder;
import fpc.aoc.year2019.day18._private.algo.Route;
import fpc.aoc.year2019.day18._private.algo.Trip;
import lombok.Getter;
import lombok.NonNull;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Maze {

  @NonNull
  public static Collector<String, ?, Maze> collector(boolean splitInput) {
    return Collectors.collectingAndThen(
        Collectors.toList(),
        splitInput ? MazeBuilder::splitAndCreate : MazeBuilder::create
    );
  }

  private final Pos[] cache;

  @NonNull
  private final boolean[] walls;

  @Getter
  private final int width;

  private final int height;

  @NonNull
  private final Map<Pos, Door> doorPositions;

  @NonNull
  private final BiMap<Pos, Key> keyPositions;

  @Getter
  @NonNull
  private final List<Key> startingKeys;

  public Maze(@NonNull boolean[] walls, int width, int height, Map<Door, Integer> doorIndexes, Map<Key, Integer> keyIndexes) {
    this.cache = IntStream.range(0, width * height).mapToObj(i -> new Pos(this, i)).toArray(Pos[]::new);
    this.walls = walls;
    this.width = width;
    this.height = height;

    this.doorPositions = doorIndexes.entrySet()
        .stream()
        .collect(Collectors.toMap(e -> cache[e.getValue()], Map.Entry::getKey));

    this.keyPositions = keyIndexes.entrySet()
        .stream()
        .collect(BiMap.collector(e -> cache[e.getValue()],
            Map.Entry::getKey));

    this.startingKeys = keyPositions.values().stream().filter(Key::isStart).toList();
  }

  public void printToStandardOutput() {
    print(System.out);
  }

  public void print(@NonNull PrintStream ps) {
    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        final int idx = h * width + w;
        final Pos pos = toPosition(idx);
        final String c;
        if (walls[idx]) {
          c = "#";
        } else {
          final Door door = doorPositions.get(pos);
          final Key key = keyPositions.get(pos);
          if (door != null) {
            c = door.idOfItsKey().toUpperCase();
          } else if (key != null) {
            c = key.isStart() ? "@" : key.id();
          } else {
            c = " ";
          }
        }
        ps.print(c);
      }
      ps.println();
    }
  }

  public Pos toPosition(int idx) {
    return cache[idx];
  }

  public Pos aboveOf(Pos pos) {
    return cache[pos.idx() - width];
  }

  public Pos belowOf(Pos pos) {
    return cache[pos.idx() + width];
  }

  public Pos rightTo(@NonNull Pos pos) {
    return cache[pos.idx() + 1];
  }

  public Pos leftTo(@NonNull Pos pos) {
    return cache[pos.idx() - 1];
  }

  public boolean isWall(@NonNull Pos pos) {
    return walls[pos.idx()];
  }

  public boolean isKeyAndNotStartingPoint(@NonNull Pos pos) {
    final Key key = keyPositions.get(pos);
    return key != null && !key.isStart();
  }

  public boolean isNotAStartingPoint(@NonNull Pos pos) {
    final Key key = keyPositions.get(pos);
    return key == null || !key.isStart();

  }

  public boolean isDoor(@NonNull Pos pos) {
    return doorPositions.containsKey(pos);
  }

  @NonNull
  public Optional<Door> getDoorAt(@NonNull Pos pos) {
    final Door door = doorPositions.get(pos);
    return Optional.ofNullable(door);
  }

  @NonNull
  public Optional<Key> getKeyAt(Pos pos) {
    final Key key = keyPositions.get(pos);
    return Optional.ofNullable(key);
  }

  @NonNull
  public Map<Trip, Route> findFastedRouteBetweenKeys() {
    return keyPositions.values()
        .stream()
        .map(this::findFastestRouteToOtherKeys)
        .flatMap(Collection::stream)
        .collect(Tools.toMap(Route::trip));
  }

  @NonNull
  private List<Route> findFastestRouteToOtherKeys(@NonNull Key reference) {
    return FastestRouteFinder.findFastestRouteToOtherKeys(this, reference);
  }

  public int numberOfKeys() {
    return keyPositions.size();
  }

  public Set<Key> allKeys() {
    return keyPositions.inverse().keySet();
  }

  public Pos keyPosition(Key key) {
    final Pos pos = keyPositions.inverse().get(key);
    if (pos == null) {
      throw new AOCException("Could not find key '" + key.id() + "'");
    }
    return pos;
  }

}
