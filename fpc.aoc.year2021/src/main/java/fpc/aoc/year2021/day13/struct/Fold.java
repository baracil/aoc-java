package fpc.aoc.year2021.day13.struct;

import java.util.function.UnaryOperator;

public sealed interface Fold {

  UnaryOperator<Dot> operator();

  record X(int pos) implements Fold {
    @Override
    public UnaryOperator<Dot> operator() {
      return d -> Dot.with(d.x() - 2 * Math.max(0, d.x() - pos), d.y());
    }
  }

  record Y(int pos) implements Fold {
    @Override
    public UnaryOperator<Dot> operator() {
      return d -> Dot.with(d.x(), d.y() - 2 * Math.max(0, d.y() - pos));
    }
  }

  static Fold parse(String line) {
    final var tokens = line.split(" ")[2].split("=");
    final var pos = Integer.parseInt(tokens[1]);
    return switch (tokens[0]) {
      case "x" -> new X(pos);
      case "y" -> new Y(pos);
      default -> throw new IllegalArgumentException("Cannot convert to fold '" + line + "'");
    };
  }

}
