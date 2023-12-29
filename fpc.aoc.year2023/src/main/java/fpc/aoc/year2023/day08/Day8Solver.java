package fpc.aoc.year2023.day08;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day8Solver extends SmartSolver<Input> {

    @Override
    protected @NonNull Converter<Input> getConverter() {
        return Converter.IDENTITY.andThen(Input::parse);
    }
}
