package fpc.aoc.common;

import fpc.aoc.common._private.PermutationIterator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class Permutation<A> implements Iterable<A> {

    public static <A> Permutation<A> createForIntReference(int[] reference, Function<? super int[],? extends A> factory) {
        final Function<IntUnaryOperator,A> f = operator -> {
            final int[] permutation = reference.clone();
            for (int i = 0; i < permutation.length; i++) {
                permutation[i] = reference[operator.applyAsInt(i)];
            }
            return factory.apply(permutation);
        };

        return new Permutation<>(reference.length,f);
    }

    @NonNull
    public static <T,A> Permutation<A> create(T[] reference, Function<? super T[],? extends A> factory) {
        final Function<IntUnaryOperator,A> f = operator -> {
            final T[] permutation = reference.clone();
            for (int i = 0; i < permutation.length; i++) {
                permutation[i] = reference[operator.applyAsInt(i)];
            }
            return factory.apply(permutation);
        };

        return new Permutation<>(reference.length,f);
    }

    private final int size;

    @NonNull
    private final Function<? super IntUnaryOperator,? extends A> factory;

    @Override
    @NonNull
    public Iterator<A> iterator() {
        return PermutationIterator.create(size,factory);
    }

    public Stream<A> stream() {
        return StreamSupport.stream(spliterator(), false);
    }
}
