package fpc.aoc.day11;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class Day11Solver extends SmartSolver<ArrayOfChar,Long> {

    @Override
    protected @NonNull Converter<ArrayOfChar> getConverter() {
        return Converter.TO_ARRAY_OF_CHAR;
    }
}
