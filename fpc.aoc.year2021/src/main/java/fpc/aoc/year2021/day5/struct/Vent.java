package fpc.aoc.year2021.day5.struct;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Vent(Position start, Position end) {

    public boolean isVerticalOrHorizontal() {
        return start.x() == end.x() || start.y() == end.y();
    }


    public Stream<Position> line() {
        final var rangeX = end.x() - start.x();
        final var rangeY = end.y() - start.y();

        final var range = Math.max(Math.abs(rangeX), Math.abs(rangeY));

        final var dx = Integer.compare(rangeX, 0);
        final var dy = Integer.compare(rangeY, 0);

        return IntStream.rangeClosed(0, range)
                        .mapToObj(i -> Position.at(start.x() + i * dx, start.y() + i * dy));

    }

    public static Vent parse(String line) {
        final var tokens = line.split("->");

        return new Vent(Position.parse(tokens[0]), Position.parse(tokens[1]));
    }


}
