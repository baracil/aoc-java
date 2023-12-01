import fpc.aoc.api.AOCProblem;
import fpc.aoc.day13.Day13Part1Solver;
import fpc.aoc.day13.Day13Part2Solver;

module fpc.aoc.day13 {
    requires static lombok;

    requires com.google.common;
    requires fpc.aoc.input;

    exports fpc.aoc.day13;

    provides AOCProblem with Day13Part1Solver, Day13Part2Solver;
}
