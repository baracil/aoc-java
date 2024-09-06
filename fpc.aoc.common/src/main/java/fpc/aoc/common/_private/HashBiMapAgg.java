package fpc.aoc.common._private;

import fpc.aoc.common.BiMap;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public class HashBiMapAgg<T, K, V> {

  private final Function<? super T, ? extends K> keyMapper;
  private final Function<? super T, ? extends V> valueMapper;

  private final BiMap<K, V> map = new HashBiMap<>();

  public void accumulate(T item) {
    final K key = this.keyMapper.apply(item);
    final V value = this.valueMapper.apply(item);
    map.put(key, value);
  }

  public HashBiMapAgg<T, K, V> combine(HashBiMapAgg<T, K, V> other) {
    this.map.putAll(other.map);
    return this;
  }

  public BiMap<K, V> build() {
    return this.map;
  }
}
