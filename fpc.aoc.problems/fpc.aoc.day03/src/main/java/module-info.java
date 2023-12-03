import fpc.aoc.api.AOCProblem;
import fpc.aoc.day3.Day3Part1Solver;
import fpc.aoc.day3.Day3Part2Solver;

module fpc.aoc.day3 {
    requires static lombok;

    requires fpc.aoc.input;



    exports fpc.aoc.day3;

    provides AOCProblem with Day3Part1Solver, Day3Part2Solver;
}
