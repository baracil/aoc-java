import fpc.aoc.api.AOCProblem;
import fpc.aoc.day11.Day11Part1Solver;
import fpc.aoc.day11.Day11Part2Solver;

module fpc.aoc.day11 {
    requires static lombok;


    requires fpc.aoc.input;

    exports fpc.aoc.day11;

    provides AOCProblem with Day11Part1Solver, Day11Part2Solver;
}
