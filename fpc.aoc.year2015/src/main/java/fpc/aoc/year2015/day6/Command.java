package fpc.aoc.year2015.day6;

import lombok.Value;

@Value
public class Command {
  Type type;
  int lowX;
  int highX;
  int lowY;
  int highY;

  public boolean isIn(int x, int y) {
    return x >= lowX && x <= highX && y >= lowY && y <= highY;
  }

  public static Command parse(String line) {
    final var tokens = line.split(" ");
    final var type = switch (tokens[1]) {
      case "on" -> Type.ON;
      case "off" -> Type.OFF;
      default -> Type.TOGGLE;
    };

    final var i = type == Type.TOGGLE ? 1 : 2;

    final var low = tokens[i].split(",");
    final var high = tokens[i + 2].split(",");

    return new Command(type,
      Integer.parseInt(low[0]),
      Integer.parseInt(high[0]),
      Integer.parseInt(low[1]),
      Integer.parseInt(high[1])
    );
  }
}
