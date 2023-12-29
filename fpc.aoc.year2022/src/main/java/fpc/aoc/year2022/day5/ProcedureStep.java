package fpc.aoc.year2022.day5;

import lombok.NonNull;

public record ProcedureStep(int repetition, int originStack, int targetStack) {

  public static @NonNull ProcedureStep parse(@NonNull String line) {
    final var tokens = line.split(" ", 6);
    return new ProcedureStep(
        Integer.parseInt(tokens[1]),
        Integer.parseInt(tokens[3]),
        Integer.parseInt(tokens[5])
    );
  }
}
