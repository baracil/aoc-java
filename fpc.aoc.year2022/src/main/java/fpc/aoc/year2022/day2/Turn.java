package fpc.aoc.year2022.day2;

import fpc.aoc.common.AOCException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Turn {

  private final Shape elfShape;
  private final Shape myShape;


  public int getScore() {
    return myShape.score() + myShape.getOutCome(elfShape).score();
  }

  public static Turn forPart1(String line) {
    final var tokens = line.split(" ", 2);
    return new Turn(parseShape(tokens[0]), parseShape(tokens[1]));
  }

  public static Turn forPart2(String line) {
    final var tokens = line.split(" ", 2);
    final var elfShape = parseShape(tokens[0]);
    final var outCome = parseOutCome(tokens[1]);

    return new Turn(elfShape, outCome.getCorrespondingShape(elfShape));
  }

  private static Shape parseShape(@NonNull String letter) {
    return switch (letter) {
      case "A", "X" -> Shape.ROCK;
      case "B", "Y" -> Shape.PAPER;
      case "C", "Z" -> Shape.SCISSORS;
      default -> throw new AOCException("Invalid letter for shape '" + letter + "'");
    };
  }

  private static OutCome parseOutCome(@NonNull String letter) {
    return switch (letter) {
      case "X" -> OutCome.LOSS;
      case "Y" -> OutCome.DRAW;
      case "Z" -> OutCome.WIN;
      default -> throw new AOCException("Invalid letter for outcome '" + letter + "'");
    };
  }
}
