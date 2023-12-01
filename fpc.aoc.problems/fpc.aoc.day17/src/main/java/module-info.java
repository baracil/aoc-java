import fpc.aoc.api.AOCProblem;
import fpc.aoc.day17.Day17Part1Solver;
import fpc.aoc.day17.Day17Part2Solver;

module fpc.aoc.day17 {
    requires static lombok;

    requires com.google.common;
    requires fpc.aoc.input;

    exports fpc.aoc.day17;

    provides AOCProblem with Day17Part1Solver, Day17Part2Solver;
}
