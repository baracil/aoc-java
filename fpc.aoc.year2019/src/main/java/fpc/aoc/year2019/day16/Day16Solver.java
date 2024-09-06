package fpc.aoc.year2019.day16;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day16Solver extends SmartSolver<Signal> {

    @Override
    protected @NonNull Converter<Signal> getConverter() {
        return Converter.FIRST_LINE.andThen(Signal::new);
    }

}
