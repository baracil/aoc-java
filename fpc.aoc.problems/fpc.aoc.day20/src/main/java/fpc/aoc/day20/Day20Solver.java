package fpc.aoc.day20;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Stream;

public abstract class Day20Solver extends SmartSolver<Circuit,Long> {

    @Override
    protected @NonNull Converter<Circuit> getConverter() {
        return s -> Circuit.create(s.map(Module::parse).toList());
    }
}
