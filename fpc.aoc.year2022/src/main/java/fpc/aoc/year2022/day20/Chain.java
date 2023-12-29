package fpc.aoc.year2022.day20;

import java.util.stream.IntStream;

public class Chain {
  private final int length;
  private final Node zero;
  private final Node[] nodes;

  public Chain(int[] values, long key) {
    length = values.length;

    nodes = new Node[length];
    for (int i = 0; i < length; i++) {
      final var value = key * values[i];
      final var step = modulate(value, length - 1);
      nodes[i] = new Node(value, step);
    }

    for (int i = 0; i < values.length; i++) {
      nodes[i].next(nodes[(i + 1) % length]);
      nodes[i].previous(nodes[(i + length - 1) % length]);
    }
    zero = IntStream.range(0, length)
        .filter(n -> values[n] == 0)
        .mapToObj(n -> nodes[n])
        .findAny().orElseThrow();
  }

  public void performOneCycle() {
    for (int i = 0; i < length; i++) {
      move(nodes[i]);
    }
  }

  private void move(Node node) {
    final var nbSteps = node.steps();
    if (nbSteps == 0) {
      return;
    }
    var current = node;
    for (int i = 0; i < nbSteps; i++) {
      current = current.next();
    }
    node.attachAfter(current);
  }


  private static int modulate(long step, int module) {
    final var value = (int) (step % module);
    if (value < 0) {
      return value + module;
    } else {
      return value;
    }
  }

  public long getCoordinate() {
    final var n = new Node[length];
    n[0] = zero;
    for (int i = 1; i < length; i++) {
      n[i] = n[i - 1].next();
    }

    return IntStream.of(1000, 2000, 3000)
        .map(i -> i % length)
        .mapToLong(i -> n[i].value())
        .sum();
  }


}
