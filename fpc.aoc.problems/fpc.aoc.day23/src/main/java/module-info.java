import fpc.aoc.api.AOCProblem;
import fpc.aoc.day23.Day23Part1Solver;
import fpc.aoc.day23.Day23Part2Solver;

module fpc.aoc.day23 {
    requires static lombok;

    requires com.google.common;
    requires fpc.aoc.input;

    exports fpc.aoc.day23;

    provides AOCProblem with Day23Part1Solver, Day23Part2Solver;
}
