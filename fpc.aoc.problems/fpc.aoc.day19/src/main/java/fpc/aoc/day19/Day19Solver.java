package fpc.aoc.day19;

import fpc.aoc.day19.model.Input;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day19Solver extends SmartSolver<Input,Long> {

    @Override
    protected @NonNull Converter<Input> getConverter() {
        return s -> s.collect(Input.COLLECTOR);
    }
}
