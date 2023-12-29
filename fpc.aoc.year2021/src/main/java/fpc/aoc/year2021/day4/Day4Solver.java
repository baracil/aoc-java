package fpc.aoc.year2021.day4;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2021.day4.struct.Day04Input;
import lombok.NonNull;

public abstract class Day4Solver extends SmartSolver<Day04Input> {

    @Override
    protected @NonNull Converter<Day04Input> getConverter() {
        return s -> s.stream().collect(Day04Input.COLLECTOR);
    }
}
