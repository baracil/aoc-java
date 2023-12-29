package fpc.aoc.year2020.day20.structures;

import fpc.aoc.common.Position;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Pattern {

    private final @NonNull Set<Position> positionsOfSharp;

    public Pattern(@NonNull String pattern) {
        final Set<Position> positions = new HashSet<>();
        final String[] lines = pattern.split("\n");
        for (int y = 0; y < lines.length; y++) {
            final var line = lines[y];
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '#') {
                    positions.add(Position.of(x, y));
                }
            }
        }
        this.positionsOfSharp = positions;
    }

    public @NonNull Stream<Position> positionsOfSharp() {
        return positionsOfSharp.stream();
    }
}
