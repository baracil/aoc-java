import fpc.aoc.api.AOCProblem;
import fpc.aoc.day2.Day2Part1Solver;
import fpc.aoc.day2.Day2Part2Solver;

module fpc.aoc.day2 {
    requires static lombok;


    requires fpc.aoc.input;

    exports fpc.aoc.day2;

    provides AOCProblem with Day2Part1Solver, Day2Part2Solver;
}
