import fpc.aoc.api.Solver;
import fpc.aoc.year2024.day01.Day1Part1Solver;
import fpc.aoc.year2024.day01.Day1Part2Solver;

module fpc.aoc.year2024 {
  requires static lombok;

  requires fpc.aoc.input;

  provides Solver with Day1Part1Solver, Day1Part2Solver;

}