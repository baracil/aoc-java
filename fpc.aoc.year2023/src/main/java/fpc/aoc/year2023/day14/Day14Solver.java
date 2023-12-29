package fpc.aoc.year2023.day14;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2023.day14.model.Platform;
import lombok.NonNull;

public abstract class Day14Solver extends SmartSolver<Platform> {

    @Override
    protected @NonNull Converter<Platform> getConverter() {
        return Converter.TO_ARRAY_OF_CHAR.andThen(Platform::new);
    }
}
