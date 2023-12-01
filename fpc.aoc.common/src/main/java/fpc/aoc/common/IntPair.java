package fpc.aoc.common;

import lombok.NonNull;

import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record IntPair(int first, int second) {

    public static @NonNull IntPair of(int a, int b) {
        return new IntPair(a, b);
    }

    public @NonNull
    IntPair swap() {
        return of(second, first);
    }

    public void addToMap(@NonNull Map<? super Integer, ? super Integer> target) {
        target.put(first, second);
    }


    public static @NonNull Stream<IntPair> cartesian(int size1, int size2) {
        return IntStream.range(0, size1)
                        .mapToObj(i -> IntStream.range(0, size2).mapToObj(j -> IntPair.of(i, j)))
                        .flatMap(s -> s);
    }

    public static @NonNull Stream<IntPair> cartesian(int size) {
        return cartesian(size, size);
    }

    public static @NonNull Stream<IntPair> cartesianWithoutSame(int size) {
        return cartesian(size, size).filter(p -> p.first == p.second);
    }
}
