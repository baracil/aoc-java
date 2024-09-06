package fpc.aoc.common;

import fpc.aoc.common._private.HashBiMap;
import fpc.aoc.common._private.HashBiMapAgg;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;

public interface BiMap<K, V> extends Map<K, V> {

  BiMap<V, K> inverse();


  static <K, V> BiMap<K, V> create() {
    return new HashBiMap<>();
  }

  static <T, K, V> Collector<T, ?, BiMap<K, V>> collector(Function<? super T, ? extends K> keyGetter, Function<? super T, ? extends V> valueGetter) {
    return Collector.of(
        () -> new HashBiMapAgg<T, K, V>(keyGetter, valueGetter),
        HashBiMapAgg::accumulate,
        HashBiMapAgg::combine,
        HashBiMapAgg::build
    );
  }

}
