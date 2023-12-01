import fpc.aoc.api.AOCProblem;
import fpc.aoc.day22.Day22Part1Solver;
import fpc.aoc.day22.Day22Part2Solver;

module fpc.aoc.day22 {
    requires static lombok;

    requires com.google.common;
    requires fpc.aoc.input;

    exports fpc.aoc.day22;

    provides AOCProblem with Day22Part1Solver, Day22Part2Solver;
}
