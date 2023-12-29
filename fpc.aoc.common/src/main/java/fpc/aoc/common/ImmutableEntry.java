package fpc.aoc.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;

import java.util.Map;

@Value
@Getter(AccessLevel.NONE)
public class ImmutableEntry<K, V> implements Map.Entry<K, V> {

  public static <K, V> Map.Entry<K, V> of(K key, V value) {
    return new ImmutableEntry<>(key, value);
  }

  K key;
  V value;

  @Override
  public K getKey() {
    return key;
  }

  @Override
  public V getValue() {
    return value;
  }

  @Override
  public V setValue(V value) {
    throw new UnsupportedOperationException();
  }
}
