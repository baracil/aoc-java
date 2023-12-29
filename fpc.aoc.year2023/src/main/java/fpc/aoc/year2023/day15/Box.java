package fpc.aoc.year2023.day15;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Box {

  private final int number;
  private final Node root = new Node("root", -1);
  private final Node tail = new Node("tail", -1);
  private final Map<String, Node> lensByName = new HashMap<>();

  public Box(int number) {
    this.number = number;
    this.root.next = this.tail;
    this.tail.previous = this.root;
  }

  public boolean isEmpty() {
    return root.next.name.equals("tail");
  }

  public int focusPower() {
    var result = 0;
    int pos = 1;
    Node current = root.next;
    while (current.focalLength >= 0) {
      result += (pos * current.focalLength * number);
      current = current.next;
      pos++;
    }
    return result;
  }

  public void removeLens(String name) {
    final var lens = lensByName.remove(name);
    if (lens != null) {
      lens.remove();
    }
  }

  public void addLens(String name, int focalLength) {
    final var existing = lensByName.remove(name);
    final var newNode = new Node(name, focalLength);
    this.lensByName.put(name, newNode);
    if (existing != null) {
      existing.replaceWith(newNode);
    } else {
      tail.addBefore(newNode);
    }
  }


  private static class Node {
    @Getter
    private final String name;
    @Getter
    private final int focalLength;
    Node previous = null;
    Node next = null;

    public Node(String name, int focalLength) {
      this.name = name;
      this.focalLength = focalLength;
    }

    public void remove() {
      this.previous.next = this.next;
      this.next.previous = this.previous;
    }

    public void replaceWith(Node node) {
      node.previous = this.previous;
      node.next = this.next;

      node.previous.next = node;
      node.next.previous = node;
    }

    public void addBefore(Node node) {
      node.previous = this.previous;
      node.next = this;

      this.previous.next = node;
      this.previous = node;
    }

    @Override
    public String toString() {
      return "[" + name + " " + focalLength + ']';
    }
  }
}
