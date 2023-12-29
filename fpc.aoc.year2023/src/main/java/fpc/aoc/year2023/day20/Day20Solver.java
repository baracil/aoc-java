package fpc.aoc.year2023.day20;


import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2023.day20.model.Circuit;
import fpc.aoc.year2023.day20.model.Module;
import lombok.NonNull;

public abstract class Day20Solver extends SmartSolver<Circuit> {

    @Override
    protected @NonNull Converter<Circuit> getConverter() {
        return Converter.forItem(Module::parse).andThen(Circuit::create);
    }
}
