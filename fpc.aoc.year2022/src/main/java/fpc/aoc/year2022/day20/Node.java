package fpc.aoc.year2022.day20;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
  private final long value;
  private final int steps;

  private Node previous;
  private Node next;

  public Node(long value, int steps) {
    this.value = value;
    this.steps = steps;
  }

  private void detach() {
    this.previous.next = this.next;
    this.next.previous = this.previous;
    this.previous = null;
    this.next = null;
  }

  public void attachAfter(Node newPrevious) {
    this.detach();

    this.previous = newPrevious;
    this.next = newPrevious.next;

    this.next.previous = this;
    this.previous.next = this;
  }

}
