import fpc.aoc.api.AOCProblem;
import fpc.aoc.day24.Day24Part1Solver;
import fpc.aoc.day24.Day24Part2Solver;

module fpc.aoc.day24 {
    requires static lombok;

    requires com.google.common;
    requires fpc.aoc.input;

    exports fpc.aoc.day24;

    provides AOCProblem with Day24Part1Solver, Day24Part2Solver;
}
