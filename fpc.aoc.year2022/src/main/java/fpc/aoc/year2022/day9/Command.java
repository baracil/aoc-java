package fpc.aoc.year2022.day9;

import fpc.aoc.common.Displacement;
import lombok.NonNull;

public record Command(@NonNull Displacement displacement, int nbSteps) {
  //R 4
  //U 4
  //L 3
  //D 1


  public static @NonNull Command parse(@NonNull String line) {
    final var tokens = line.split(" ");
    final var nbSteps = Integer.parseInt(tokens[1]);
    final var displacement = switch (tokens[0]) {
      case "U" -> Displacement.N;
      case "D" -> Displacement.S;
      case "L" -> Displacement.W;
      case "R" -> Displacement.E;
      default -> throw new IllegalArgumentException("Cannot parse '"+tokens[0]+"' as displacement");
    };
    return new Command(displacement,nbSteps);
  }

}
