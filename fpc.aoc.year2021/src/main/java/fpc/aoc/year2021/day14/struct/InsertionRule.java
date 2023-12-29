package fpc.aoc.year2021.day14.struct;

import lombok.NonNull;

public record InsertionRule(@NonNull Couple couple, char middle) {

    public static @NonNull InsertionRule parse(@NonNull String line) {
        final var tokens = line.split("->");
        return new InsertionRule(new Couple(tokens[0].charAt(0), tokens[0].charAt(1)), tokens[1].charAt(1));
    }
}
