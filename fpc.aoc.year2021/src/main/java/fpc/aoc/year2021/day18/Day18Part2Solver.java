package fpc.aoc.year2021.day18;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day18.struct.Number;
import lombok.NonNull;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day18Part2Solver extends Day18Solver {

    public static @NonNull Solver provider() {
        return new Day18Part2Solver();
    }

    @Override
    public @NonNull Long doSolve(@NonNull Stream<Number> input) {
        final var numbers = input.toList();


        return IntStream.range(0, numbers.size() - 1)
                .mapToObj(i -> IntStream.range(i + 1, numbers.size()).mapToLong(j -> maxMagnitude(numbers.get(i), numbers.get(j))).boxed())
                .flatMap(s -> s)
                .mapToLong(s -> s)
                .max()
                .orElseThrow();

    }

    private long maxMagnitude(Number number1, Number number2) {
        final var mag1 = number1.add(number2).magnitude();
        final var mag2 = number2.add(number1).magnitude();
        return Math.max(mag1,mag2);
    }
}
