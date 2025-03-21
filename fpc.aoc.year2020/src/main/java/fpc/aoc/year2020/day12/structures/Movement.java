package fpc.aoc.year2020.day12.structures;

import lombok.Value;

@Value
public class Movement {

  Operation operation;
  int quantity;

  public static Movement parse(String line) {
    final Operation operation = Operation.parse(line.substring(0, 1));
    final int quantity = Integer.parseInt(line.substring(1));
    return new Movement(operation, quantity);
  }

}
