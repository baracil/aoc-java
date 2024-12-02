package fpc.aoc.year2021.day18.struct;

import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
public enum Side {
  UNDEFINED(p -> null),
  LEFT(Node.Pair::left),
  RIGHT(Node.Pair::right),
  ;

  private final Function<Node.Pair, Node> getter;

  public Side getOther() {
    return switch (this) {
      case UNDEFINED -> UNDEFINED;
      case LEFT -> RIGHT;
      case RIGHT -> LEFT;
    };
  }

  public Optional<Node> getOtherChild(Node node) {
    return this.getOther().getChild(node);
  }

  public Optional<Node> getChild(Node node) {
    return switch (node) {
      case Node.Literal l -> Optional.empty();
      case Node.Pair pair -> Optional.ofNullable(getter.apply(pair));
    };
  }

}
