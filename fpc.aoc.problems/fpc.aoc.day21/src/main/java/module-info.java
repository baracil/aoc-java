import fpc.aoc.api.AOCProblem;
import fpc.aoc.day21.Day21Part1Solver;
import fpc.aoc.day21.Day21Part2Solver;

module fpc.aoc.day21 {
    requires static lombok;


    requires fpc.aoc.input;

    exports fpc.aoc.day21;

    provides AOCProblem with Day21Part1Solver, Day21Part2Solver;
}
