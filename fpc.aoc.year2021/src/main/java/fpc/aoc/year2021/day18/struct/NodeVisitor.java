package fpc.aoc.year2021.day18.struct;

import lombok.NonNull;

import java.util.Optional;

public interface NodeVisitor<T> {

  @NonNull Optional<T> entering(Node node);

  default void leaving(Node node) {
  }

  ;


  static @NonNull NodeVisitor<Node.Literal> firstLiteralToSplit() {
    return node -> {
      if (node instanceof Node.Literal literal && literal.value() >= 10) {
        return Optional.of(literal);
      }
      return Optional.empty();
    };
  }

  static @NonNull NodeVisitor<Node.Pair> firstFinalPairWithDepthGreaterThan(int depth) {
    return new NodeVisitor<>() {
      private int count = 0;

      @Override
      public @NonNull Optional<Node.Pair> entering(Node node) {
        count++;
        if (count >= depth && node instanceof Node.Pair pair && pair.isFinal()) {
          return Optional.of(pair);
        }
        return Optional.empty();
      }

      @Override
      public void leaving(Node node) {
        --count;
      }
    };
  }

  static @NonNull NodeVisitor<Node.Literal> firstLiteral() {
    return node -> switch (node) {
      case Node.Literal literal -> Optional.of(literal);
      case Node.Pair ignored -> Optional.empty();
    };

  }

}
