import fpc.aoc.api.Solver;
import fpc.aoc.year2024.day01.Day1Part1Solver;
import fpc.aoc.year2024.day01.Day1Part2Solver;
import fpc.aoc.year2024.day02.Day2Part1Solver;
import fpc.aoc.year2024.day02.Day2Part2Solver;
import fpc.aoc.year2024.day03.Day3Part1Solver;
import fpc.aoc.year2024.day03.Day3Part2Solver;

module fpc.aoc.year2024 {
  requires static lombok;

  requires fpc.aoc.input;

  provides Solver with
      Day1Part1Solver, Day1Part2Solver,
      Day2Part1Solver, Day2Part2Solver,
      Day3Part1Solver, Day3Part2Solver
      ;

}