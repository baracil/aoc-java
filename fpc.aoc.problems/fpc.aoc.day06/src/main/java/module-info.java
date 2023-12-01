import fpc.aoc.api.AOCProblem;
import fpc.aoc.day6.Day6Part1Solver;
import fpc.aoc.day6.Day6Part2Solver;

module fpc.aoc.day6 {
    requires static lombok;

    requires com.google.common;
    requires fpc.aoc.input;

    exports fpc.aoc.day6;

    provides AOCProblem with Day6Part1Solver, Day6Part2Solver;
}
