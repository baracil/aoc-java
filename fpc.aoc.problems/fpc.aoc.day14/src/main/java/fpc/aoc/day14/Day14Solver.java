package fpc.aoc.day14;

import fpc.aoc.day14.model.Platform;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day14Solver extends SmartSolver<Platform,Integer> {

    @Override
    protected @NonNull Converter<Platform> getConverter() {
        return Converter.TO_ARRAY_OF_CHAR.andThen(Platform::new);
    }
}
