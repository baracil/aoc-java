package fpc.aoc.year2021.day5.struct;

public record Position(int x, int y) {

    public static Position at(int x, int y) {
        return new Position(x,y);
    }

    public static Position parse(String positionAsString) {
        final var tokens = positionAsString.trim().split(",");

        return Position.at(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
    }
}
