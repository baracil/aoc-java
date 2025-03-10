package fpc.aoc.year2019.day12;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2019.day12.computation.MoonSystem;

public abstract class Day12Solver extends SmartSolver<MoonSystem> {



    @Override
    protected Converter<MoonSystem> getConverter() {
        return MoonSystem::build;
    }
}
