package fpc.aoc.common._private;

import fpc.aoc.common.BiMap;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
public class HashBiMap<K, V> implements BiMap<K, V> {

  private final Map<K, V> direct;
  private final Map<V, K> reverse;

  public HashBiMap() {
    this.direct = new HashMap<>();
    this.reverse = new HashMap<>();
  }

  @Override
  public BiMap<V, K> inverse() {
    return new HashBiMap<V, K>(reverse, direct);
  }

  @Override
  public int size() {
    return direct.size();
  }

  @Override
  public boolean isEmpty() {
    return direct.isEmpty();
  }

  @Override
  public boolean containsKey(Object key) {
    return direct.containsKey(key);
  }

  @Override
  public boolean containsValue(Object value) {
    return reverse.containsKey(value);
  }

  @Override
  public V get(Object key) {
    return direct.get(key);
  }

  @Override
  public V put(K key, V value) {
    final var old = direct.put(key, value);
    reverse.remove(old);
    reverse.put(value, key);
    return old;
  }

  @Override
  public V remove(Object key) {
    final var value = direct.remove(key);
    reverse.remove(value);
    return value;
  }

  @Override
  public void putAll(Map<? extends K, ? extends V> m) {
    m.forEach(this::put);
  }

  @Override
  public void clear() {
    this.direct.clear();
    this.reverse.clear();
  }

  @Override
  public Set<K> keySet() {
    return direct.keySet();
  }

  @Override
  public Collection<V> values() {
    return direct.values();
  }

  @Override
  public Set<Entry<K, V>> entrySet() {
    return direct.entrySet();
  }
}
