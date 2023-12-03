import fpc.aoc.api.AOCProblem;
import fpc.aoc.day7.Day7Part1Solver;
import fpc.aoc.day7.Day7Part2Solver;

module fpc.aoc.day7 {
    requires static lombok;


    requires fpc.aoc.input;

    exports fpc.aoc.day7;

    provides AOCProblem with Day7Part1Solver, Day7Part2Solver;
}
