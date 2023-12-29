package fpc.aoc.year2021.day18.struct;

import lombok.*;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public sealed abstract class Node {

  @Getter
  private Pair parent;
  @Getter
  private Side side;

  public abstract Node duplicate();

  public void detach() {
    if (parent != null) {
      if (parent.left() == this) {
        parent.setLeft(new Literal(0));
      } else if (parent.right() == this) {
        parent.setRight(new Literal(0));
      }
      parent = null;
      side = null;
    }
  }

  public boolean isRoot() {
    return parent == null;
  }

  public abstract boolean isLiteral();

  public abstract long magnitude();

  @AllArgsConstructor
  public static final class Literal extends Node {
    @Getter
    private int value;

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public void addValue(int value) {
      this.value += value;
    }

    @Override
    public boolean isLiteral() {
      return true;
    }

    @Override
    public Node duplicate() {
      return new Literal(value);
    }

    @Override
    public long magnitude() {
      return value;
    }
  }

  public static final class Pair extends Node {
    @Getter
    private @NonNull Node left;
    @Getter
    private @NonNull Node right;

    public Pair(@NonNull Node left, @NonNull Node right) {
      this.left = left;
      this.right = right;
      this.left.parent = this;
      this.left.side = Side.LEFT;
      this.right.parent = this;
      this.right.side = Side.RIGHT;
    }

    public boolean isFinal() {
      return left.isLiteral() && right.isLiteral();
    }

    @Override
    public boolean isLiteral() {
      return false;
    }

    @Override
    public String toString() {
      return "[" + left + "," + right + "]";
    }

    public void setRight(Node node) {
      this.right = node;
      this.right.side = Side.RIGHT;
      this.right.parent = this;
    }

    public void setLeft(Node node) {
      this.left = node;
      this.left.side = Side.LEFT;
      this.left.parent = this;
    }

    public void setChild(Side side, Pair pair) {
      switch (side) {
        case LEFT -> setLeft(pair);
        case RIGHT -> setRight(pair);
      }

    }

    @Override
    public Node duplicate() {
      return new Pair(left.duplicate(), right.duplicate());
    }

    @Override
    public long magnitude() {
      return 3 * left.magnitude() + 2 * right.magnitude();
    }
  }

}