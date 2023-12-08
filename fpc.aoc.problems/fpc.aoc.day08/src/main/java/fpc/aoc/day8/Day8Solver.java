package fpc.aoc.day8;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day8Solver extends SmartSolver<Input,String> {

    @Override
    protected @NonNull Converter<Input> getConverter() {
        return Converter.ALL_LINES.andThen(Input::parse);
    }
}
