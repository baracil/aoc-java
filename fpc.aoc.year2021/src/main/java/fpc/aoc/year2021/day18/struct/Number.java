package fpc.aoc.year2021.day18.struct;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.function.Supplier;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Number {

  public static final Number NIL = new Number(null);

  final Node root;

  public static Number parse(String input) {
    final var parsing = NumberParser.parse(input);
    return new Number(parsing);
  }


  public Number add(Number other) {
    if (this.root == null) {
      return new Number(other.root.duplicate());
    } else if (other.root == null) {
      return new Number(this.root.duplicate());
    } else {
      final var result = new Number(new Node.Pair(this.root.duplicate(), other.root.duplicate()));
      result.reduce();
      return result;
    }
  }


  public long magnitude() {
    return root == null ? 0 : root.magnitude();
  }


  public void reduce() {
    while (true) {
      while (this.explode()) ;
      if (!this.split()) {
        break;
      }
    }
  }


  public boolean split() {
    if (root == null) {
      return false;
    }
    final var toSplit = this.findDFS(root, NodeVisitor.firstLiteralToSplit(), Side.LEFT).orElse(null);

    if (toSplit == null) {
      return false;
    }

    final var leftValue = toSplit.value() / 2;
    final var rightValue = toSplit.value() - leftValue;

    toSplit.parent().setChild(toSplit.side(), new Node.Pair(new Node.Literal(leftValue), new Node.Literal(rightValue)));
    return true;
  }


  public boolean explode() {
    if (root == null) {
      return false;
    }
    final var toExplode = this.findDFS(root, NodeVisitor.firstFinalPairWithDepthGreaterThan(5), Side.LEFT).orElse(null);

    if (toExplode == null) {
      return false;
    }

    final var leftLiteral = (Node.Literal) toExplode.left();
    final var rightLiteral = (Node.Literal) toExplode.right();

    findFirstLiteral(leftLiteral, Side.LEFT).ifPresent(l -> l.addValue(leftLiteral.value()));
    findFirstLiteral(rightLiteral, Side.RIGHT).ifPresent(l -> l.addValue(rightLiteral.value()));

    toExplode.detach();
    return true;
  }

  private Optional<Node.Literal> findFirstLiteral(Node node, Side side) {
    Node current = node;
    while (!current.isRoot()) {
      final Node.Pair parent = current.parent();
      final Node child = side.getChild(parent).orElseThrow();
      if (child != current) {
        return findDFS(child, NodeVisitor.firstLiteral(), side.getOther());
      }
      current = parent;
    }
    return Optional.empty();
  }


  @Override
  public String toString() {
    return root == null ? "[]" : root.toString();
  }

  private <T> Optional<T> findDFS(Node node, NodeVisitor<T> visitor, Side firstToCheck) {
    try {
      final var result = visitor.entering(node);
      if (result.isPresent()) {
        return result;
      }
      final Supplier<Optional<T>> findOnFirst = () -> firstToCheck.getChild(node).flatMap(c -> findDFS(c, visitor, firstToCheck));
      final Supplier<Optional<T>> findOnOther = () -> firstToCheck.getOtherChild(node).flatMap(c -> findDFS(c, visitor, firstToCheck));

      return findOnFirst.get().or(findOnOther);
    } finally {
      visitor.leaving(node);
    }
  }
}


