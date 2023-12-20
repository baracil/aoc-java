import fpc.aoc.api.AOCProblem;
import fpc.aoc.day19.Day19Part1Solver;
import fpc.aoc.day19.Day19Part2Solver;

module fpc.aoc.day19 {
    requires static lombok;


    requires fpc.aoc.input;

    exports fpc.aoc.day19;
  exports fpc.aoc.day19.model;

  provides AOCProblem with Day19Part1Solver, Day19Part2Solver;
}
