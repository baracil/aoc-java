package fpc.aoc.year2019.day23;

import fpc.aoc.api.Solver;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.ProgramBasedSolver;
import fpc.aoc.year2019.day23._private.FirstYNetwork;

/**
 * @author Bastien Aracil
 **/
public class Day23Part1Solver extends ProgramBasedSolver {

    public static Solver provider() {
        return new Day23Part1Solver();
    }


    @Override
    protected String doSolve(Program program) {
        return new FirstYNetwork(program).waitForResult();
    }
}
