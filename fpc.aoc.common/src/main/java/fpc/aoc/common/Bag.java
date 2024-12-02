package fpc.aoc.common;

public interface Bag<T> {

  static <T> Bag<T> create() {
    return new HashBag<>();
  }

  int quantity(T element);

  void addOne(T element);

  void removeOne(T element);


}
