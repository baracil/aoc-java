package fpc.aoc.year2022.day17;

import java.util.List;

public class ShapeGenerator {

  public final List<ShapeType> shapes = List.of(
      ShapeType.HBAR, ShapeType.CROSS, ShapeType.CORNER, ShapeType.VBAR, ShapeType.SQUARE
  );

  public ShapeType getShape(int index) {
    return shapes.get(index % shapes.size());
  }
}
