package fpc.aoc.common;

import lombok.NonNull;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public record Pair<A, B>(A first, B second) {

  public static <A, B> Pair<A, B> of(A a, B b) {
    return new Pair<>(a, b);
  }

  public @NonNull
  Pair<B, A> swap() {
    return of(second, first);
  }

  public void addToMap(Map<? super A, ? super B> target) {
    target.put(first, second);
  }

  public static <A> Pair<A, A> extract(List<A> list, IntPair indices) {
    return Pair.of(list.get(indices.first()), list.get(indices.second()));
  }

  public static <A, B> Stream<Pair<A, B>> cartesian(Collection<A> collection1, Collection<B> collection2) {
    return collection1.stream().flatMap(a -> collection2.stream().map(b -> Pair.of(a, b)));
  }

  public static <A, B> Stream<Pair<A, B>> cartesianWithoutSame(Collection<A> collection1, Collection<B> collection2) {
    return collection1.stream().flatMap(a -> collection2.stream().map(b -> Pair.of(a, b)))
        .filter(p -> p.first != p.second);
  }

}
