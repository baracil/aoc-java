package fpc.aoc.year2022.day14;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Position;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public record Path(List<Position> points) {

  public Stream<Position> positions() {
    return IntStream.range(1, points.size())
        .mapToObj(i -> linePosition(points.get(i - 1), points.get(i)))
        .flatMap(s -> s);
  }

  private Stream<Position> linePosition(Position start, Position end) {
    final int dx = end.x() - start.x();
    final int dy = end.y() - start.y();

    if (dx == 0 && dy == 0) {
      return Stream.of(start);
    }
    if (dx != 0 && dy != 0) {
      throw new AOCException("Dunno");
    }
    final int n = Math.max(Math.abs(dx), Math.abs(dy));
    final int ddx = Integer.compare(dx, 0);
    final int ddy = Integer.compare(dy, 0);
    return IntStream.rangeClosed(0, n).mapToObj(i -> start.translate(ddx * i, ddy * i));
  }


  public static Path parse(String line) {
    final var points = Arrays.stream(line.split(" -> "))
        .map(Position::parseCommaSeparated)
        .toList();
    return new Path(points);
  }


}
