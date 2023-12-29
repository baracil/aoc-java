package fpc.aoc.common;

import lombok.NonNull;

public interface Bag<T> {

  static <T> @NonNull Bag<T> create() {
    return new HashBag<>();
  }

  int quantity(@NonNull T element);

  void addOne(@NonNull T element);

  void removeOne(@NonNull T element);


}
