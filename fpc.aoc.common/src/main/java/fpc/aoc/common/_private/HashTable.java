package fpc.aoc.common._private;

import fpc.aoc.common.Table;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class HashTable<R, C, V> implements Table<R, C, V> {

  private final Map<R, Map<C, V>> valuesByRow = new HashMap<>();
  private final Map<C, Map<R, V>> valuesByColumn = new HashMap<>();

  @Override
  public void put(R row, C column, V value) {
    valuesByColumn.computeIfAbsent(column, c -> new HashMap<>()).put(row, value);
    valuesByRow.computeIfAbsent(row, c -> new HashMap<>()).put(column, value);
  }

  @Override
  public V get(R row, C column) {
    return valuesByRow.getOrDefault(row, Map.of()).get(column);
  }

  @Override
  public Collection<V> values() {
    return valuesByRow.values().stream().map(Map::values).flatMap(Collection::stream).toList();
  }

  @Override
  public Map<C, V> row(R row) {
    return valuesByRow.getOrDefault(row, Map.of());
  }

  @Override
  public Map<R, V> column(C column) {
    return valuesByColumn.getOrDefault(column, Map.of());
  }
}
