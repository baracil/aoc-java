package fpc.aoc.year2023.day18.model;

import fpc.aoc.common.Position;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Polygon {
  private final List<Position> vertices;
  @Getter
  private final long perimeter;


  public static Polygon from(List<Instruction> instructions) {
    final var result = new ArrayList<Position>(instructions.size());
    var perimeter = 0L;
    var current = Position.of(0, 0);
    for (Instruction instruction : instructions) {
      perimeter += instruction.length();
      current = current.displaced(instruction);
      result.add(current);
    }
    return new Polygon(result, perimeter);
  }

  public long area() {
    var area = 0L;
    var previous = vertices.getLast();
    for (final Position current : vertices) {
      final long x1 = previous.x();
      final long y1 = previous.y();

      final long x2 = current.x();
      final long y2 = current.y();

      area += x1 * y2 - x2 * y1;

      previous = current;
    }
    return Math.abs(area / 2);
  }
}
