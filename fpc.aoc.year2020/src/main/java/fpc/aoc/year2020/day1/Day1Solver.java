package fpc.aoc.year2020.day1;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.IntStream;

public abstract class Day1Solver<O> extends SmartSolver<int[]> {

    @Override
    protected @NonNull
    Converter<int[]> getConverter() {
        return Converter.TO_INT_STREAM.andThen(IntStream::toArray);
    }


}
