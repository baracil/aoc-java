package fpc.aoc.common;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.Value;

import java.util.Map;
import java.util.stream.Stream;

public record Pair<A, B>(@NonNull A first, @NonNull B second) {

    public static <A, B> @NonNull Pair<A, B> of(@NonNull A a, @NonNull B b) {
        return new Pair<>(a, b);
    }

    public @NonNull
    Pair<B, A> swap() {
        return of(second, first);
    }

    public void addToMap(@NonNull Map<? super A, ? super B> target) {
        target.put(first, second);
    }

    public static @NonNull <A> Pair<A,A> extract(@NonNull ImmutableList<A> list, @NonNull IntPair indices) {
        return Pair.of(list.get(indices.first()), list.get(indices.second()));
    }

    public static <A,B> @NonNull Stream<Pair<A,B>> cartesian(ImmutableCollection<A> collection1, ImmutableCollection<B> collection2) {
        return collection1.stream().flatMap(a -> collection2.stream().map(b -> Pair.of(a, b)));
    }

    public static <A,B> @NonNull Stream<Pair<A,B>> cartesianWithoutSame(ImmutableCollection<A> collection1, ImmutableCollection<B> collection2) {
        return collection1.stream().flatMap(a -> collection2.stream().map(b -> Pair.of(a, b)))
                .filter(p -> p.first != p.second);
    }

}
