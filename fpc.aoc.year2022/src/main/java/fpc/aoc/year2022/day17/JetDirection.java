package fpc.aoc.year2022.day17;

import fpc.aoc.common.AOCException;
import lombok.RequiredArgsConstructor;

import java.util.function.BiConsumer;

@RequiredArgsConstructor
public enum JetDirection {
  LEFT(Shape::moveLeft),
  RIGHT(Shape::moveRight),
  ;

  private final BiConsumer<Shape, Chamber> mover;

  public static JetDirection get(int representation) {
    return switch (representation) {
      case '<' -> LEFT;
      case '>' -> RIGHT;
      default -> throw new AOCException("Illegal represention : '" + representation + "'");
    };
  }

  public void move(Shape shape, Chamber chamber) {
    mover.accept(shape, chamber);
  }
}
