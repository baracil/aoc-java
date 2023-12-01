import fpc.aoc.api.AOCProblem;
import fpc.aoc.day4.Day4Part1Solver;
import fpc.aoc.day4.Day4Part2Solver;

module fpc.aoc.day4 {
    requires static lombok;

    requires com.google.common;
    requires fpc.aoc.input;

    exports fpc.aoc.day4;

    provides AOCProblem with Day4Part1Solver, Day4Part2Solver;
}
