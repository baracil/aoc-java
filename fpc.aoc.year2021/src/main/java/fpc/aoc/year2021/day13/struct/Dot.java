package fpc.aoc.year2021.day13.struct;

import lombok.NonNull;

public record Dot(int x, int y) {

    public static @NonNull Dot with(int x, int y) {
        return new Dot(x,y);
    }

    public static @NonNull Dot parse(@NonNull String line) {
        final var tokens = line.split(",");
        return Dot.with(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
    }
}
