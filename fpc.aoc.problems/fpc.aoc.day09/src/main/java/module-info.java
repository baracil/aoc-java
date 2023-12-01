import fpc.aoc.api.AOCProblem;
import fpc.aoc.day9.Day9Part1Solver;
import fpc.aoc.day9.Day9Part2Solver;

module fpc.aoc.day9 {
    requires static lombok;

    requires com.google.common;
    requires fpc.aoc.input;

    exports fpc.aoc.day9;

    provides AOCProblem with Day9Part1Solver, Day9Part2Solver;
}
