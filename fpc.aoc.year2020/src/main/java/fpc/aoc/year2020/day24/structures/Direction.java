package fpc.aoc.year2020.day24.structures;

import lombok.NonNull;

import java.util.Set;
import java.util.stream.Stream;

public enum Direction {
    E,
    SE,
    SW,
    W,
    NW,
    NE,
    ;

    public static @NonNull Stream<Direction> all() {
        return Holder.ALL.stream();
    }

    private static class Holder {

        private static final Set<Direction> ALL = Set.of(Direction.values());
    }
}
