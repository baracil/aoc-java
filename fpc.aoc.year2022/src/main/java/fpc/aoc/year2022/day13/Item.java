package fpc.aoc.year2022.day13;

import fpc.aoc.common.AOCException;
import lombok.NonNull;

import java.util.stream.Collectors;

public sealed interface Item extends Comparable<Item> permits Item.Scalar, Item.List {


  record Scalar(int value) implements Item {
    @Override
    public String toString() {
      return "" + value;
    }

    @Override
    public int compareTo(@NonNull Item o) {
      if (o instanceof Scalar s) {
        return ItemComparator.compare(this, s);
      } else if (o instanceof List l) {
        return ItemComparator.compare(this, l);
      }
      throw new AOCException("When will pattern matching available !!");
    }
  }

  record List(java.util.List<Item> items) implements Item {
    @Override
    public String toString() {
      return items.stream().map(Object::toString).collect(Collectors.joining(",", "[", "]"));
    }

    public Item get(int idx) {
      return items.get(idx);
    }

    public boolean isEmpty() {
      return items.isEmpty();
    }

    @Override
    public int compareTo(@NonNull Item o) {
      if (o instanceof Scalar s) {
        return ItemComparator.compare(this, s);
      } else if (o instanceof List l) {
        return ItemComparator.compare(this, l);
      }
      throw new AOCException("When will pattern matching available !!");
    }

    public int size() {
      return items.size();
    }
  }
}
