import fpc.aoc.api.AOCProblem;
import fpc.aoc.day12.Day12Part1Solver;
import fpc.aoc.day12.Day12Part2Solver;

module fpc.aoc.day12 {
    requires static lombok;

    requires com.google.common;
    requires fpc.aoc.input;

    exports fpc.aoc.day12;

    provides AOCProblem with Day12Part1Solver, Day12Part2Solver;
}
