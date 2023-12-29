package fpc.aoc.year2022.day17;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;
import lombok.Getter;

import java.util.List;
//   8
// 1 - 2
//   4

//  10 - A, 11 - B, 12 - C, 13 - D, 14 - E, 15 -F

@Getter
public enum ShapeType {
  HBAR("####"),
  VBAR("""
      #
      #
      #
      #
      """),
  CROSS("""
      .#.
      ###
      .#.
      """),
  CORNER("""
      ..#
      ..#
      ###
      """),
  SQUARE("""
      ##
      ##
      """);

  private final List<Position> rocks;

  ShapeType(String shape) {
    final var chars = ArrayOfChar.from(shape, '.');
    final var height = chars.height();
    this.rocks = chars.positionStream()
        .filter(p -> chars.get(p) != '.')
        .map(p -> Position.of(p.x(), height - p.y() - 1))
        .toList();
  }

}
