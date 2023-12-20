package fpc.aoc.day20;

import fpc.aoc.day20.model.Circuit;
import fpc.aoc.day20.model.Module;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day20Solver extends SmartSolver<Circuit,Long> {

    @Override
    protected @NonNull Converter<Circuit> getConverter() {
        return s -> Circuit.create(s.map(Module::parse).toList());
    }
}
