package fpc.aoc.year2021.day14.struct;

import lombok.NonNull;

import java.util.stream.Stream;

public record Couple(char left, char right) {


    public int leftIndex() {
        return left-'A';
    }

    public int rightIndex() {
        return right-'A';
    }


    public @NonNull Stream<Couple> split(char middle) {
        return Stream.of(new Couple(left, middle), new Couple(middle, right));
    }

    public @NonNull Couple merge(@NonNull Couple right) {
        if (this.right != right.left) {
            throw new UnsupportedOperationException();
        }
        return new Couple(this.left, right.right);
    }
}
