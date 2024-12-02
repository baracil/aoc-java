package fpc.aoc.year2021.day14.struct;

import java.util.stream.Stream;

public record Couple(char left, char right) {


  public int leftIndex() {
    return left - 'A';
  }

  public int rightIndex() {
    return right - 'A';
  }


  public Stream<Couple> split(char middle) {
    return Stream.of(new Couple(left, middle), new Couple(middle, right));
  }

  public Couple merge(Couple right) {
    if (this.right != right.left) {
      throw new UnsupportedOperationException();
    }
    return new Couple(this.left, right.right);
  }
}
