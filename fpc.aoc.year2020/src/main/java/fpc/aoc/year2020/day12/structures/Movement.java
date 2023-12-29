package fpc.aoc.year2020.day12.structures;

import lombok.NonNull;
import lombok.Value;

@Value
public class Movement {

  @NonNull Operation operation;
  int quantity;

  public static @NonNull Movement parse(@NonNull String line) {
    final Operation operation = Operation.parse(line.substring(0, 1));
    final int quantity = Integer.parseInt(line.substring(1));
    return new Movement(operation, quantity);
  }

}
