package fpc.aoc.common;

import fpc.aoc.common._private.HashTable;

import java.util.Collection;
import java.util.Map;

public interface Table<R, C, V> {

  static <R, C, V> Table<R, C, V> create() {
    return new HashTable<>();
  }

  V get(R row, C column);

  Collection<V> values();

  Map<C, V> row(R var1);

  Map<R, V> column(C var1);

  void put(R row, C column, V value);

  void clear();
}
