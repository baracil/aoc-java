package fpc.aoc.day5;

import fpc.aoc.day5.data.Input;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day5Solver extends SmartSolver<Input,String> {

    @Override
    protected @NonNull Converter<Input> getConverter() {
        return s -> s.collect(Input.COLLECTOR);
    }
}
