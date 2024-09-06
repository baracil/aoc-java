package fpc.aoc.year2019.day12;

import fpc.aoc.api.Solver;
import fpc.aoc.year2019.day12.computation.MoonSystem;
import fpc.aoc.year2019.day12.computation.Simulator;
import lombok.NonNull;

public class Day12Part1Solver extends Day12Solver {

    public static Solver provider() {
        return new Day12Part1Solver();
    }


    @Override
    protected String doSolve(@NonNull MoonSystem moonSystem) {
        final Simulator simulator = new Simulator(moonSystem);
        final MoonSystem system = simulator.simulateToTime(1000);

        return ""+system.totalEnergy();

    }
}
