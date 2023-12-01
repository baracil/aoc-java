import fpc.aoc.api.AOCProblem;
import fpc.aoc.day25.Day25Part1Solver;
import fpc.aoc.day25.Day25Part2Solver;

module fpc.aoc.day25 {
    requires static lombok;

    requires com.google.common;
    requires fpc.aoc.input;

    exports fpc.aoc.day25;

    provides AOCProblem with Day25Part1Solver, Day25Part2Solver;
}
