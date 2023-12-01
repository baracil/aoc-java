import fpc.aoc.api.AOCProblem;
import fpc.aoc.day10.Day10Part1Solver;
import fpc.aoc.day10.Day10Part2Solver;

module fpc.aoc.day10 {
    requires static lombok;

    requires com.google.common;
    requires fpc.aoc.input;

    exports fpc.aoc.day10;

    provides AOCProblem with Day10Part1Solver, Day10Part2Solver;
}
