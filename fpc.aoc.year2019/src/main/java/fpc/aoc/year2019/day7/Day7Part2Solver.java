package fpc.aoc.year2019.day7;

import fpc.aoc.api.Solver;
import fpc.aoc.computer.Program;

public class Day7Part2Solver extends Day7Solver {

    public static Solver provider() {
        return new Day7Part2Solver();
    }


    @Override
    protected Circuit createCircuit(Program program) {
        return new CircuitWithFeedback(program);
    }

    @Override
    protected String[] phaseValues() {
            return new String[]{"5","6","7","8","9"};
    }

}
