package fpc.aoc.common._private;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class PermutationIterator<A> implements Iterator<A> {

    @NonNull
    public static <T,A> PermutationIterator<A> create(int size, Function<? super IntUnaryOperator,? extends A> factory) {
        return new PermutationIterator<>(size, ints -> {
            final IntUnaryOperator operator = i -> ints[i];
            return factory.apply(operator);
        });
    }

    @NonNull
    private final Function<int[],A> factory;

    private final int size;

    private final int[] indexes;

    private final int[] c;

    private int i;

    private A next;

    private PermutationIterator(
            int size,
            @NonNull Function<int[],A> factory
    ) {
        this.size = size;
        this.indexes = IntStream.range(0,size).toArray();
        this.c = new int[size];
        this.factory = factory;
        this.next = factory.apply(indexes);
        Arrays.fill(this.c,0);
        i = 0;
    }


    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public A next() {
        final A result = this.next;
        if (result == null) {
            throw new NoSuchElementException();
        }
        pointToNext();
        return result;
    }

    private void pointToNext() {
        next = null;
        while (i < size) {
            if (c[i] < i) {
                if (isEven(i)) {
                    swapPosition(0,i);
                }
                else {
                    swapPosition(c[i],i);
                }
                this.next = factory.apply(indexes);
                c[i]+=1;
                i=0;
                break;
            }
            else {
                c[i] = 0;
                i+=1;
            }
        }
    }

    private void swapPosition(int idx1, int idx2) {
        final int aux = indexes[idx1];
        indexes[idx1] = indexes[idx2];
        indexes[idx2] = aux;
    }

    private boolean isEven(int number) {
        return (number%2) == 0;
    }

}
