import fpc.aoc.api.AOCProblem;
import fpc.aoc.day1.Day1Part1Solver;
import fpc.aoc.day1.Day1Part2Solver;

module fpc.aoc.day1 {
    requires static lombok;
    requires fpc.aoc.input;

    requires com.google.common;
    exports fpc.aoc.day1;

    provides AOCProblem with Day1Part1Solver, Day1Part2Solver;
}
