import fpc.aoc.api.Solver;
import fpc.aoc.year2024.day01.Day1Part1Solver;
import fpc.aoc.year2024.day01.Day1Part2Solver;
import fpc.aoc.year2024.day02.Day2Part1Solver;
import fpc.aoc.year2024.day02.Day2Part2Solver;
import fpc.aoc.year2024.day03.Day3Part1Solver;
import fpc.aoc.year2024.day03.Day3Part2Solver;
import fpc.aoc.year2024.day04.Day4Part1Solver;
import fpc.aoc.year2024.day04.Day4Part2Solver;
import fpc.aoc.year2024.day05.Day5Part1Solver;
import fpc.aoc.year2024.day05.Day5Part2Solver;
import fpc.aoc.year2024.day06.Day6Part1Solver;
import fpc.aoc.year2024.day06.Day6Part2Solver;
import fpc.aoc.year2024.day07.Day7Part1Solver;
import fpc.aoc.year2024.day07.Day7Part2Solver;
import fpc.aoc.year2024.day08.Day8Part1Solver;
import fpc.aoc.year2024.day08.Day8Part2Solver;
import fpc.aoc.year2024.day09.Day9Part1Solver;
import fpc.aoc.year2024.day09.Day9Part2Solver;
import fpc.aoc.year2024.day10.Day10Part1Solver;
import fpc.aoc.year2024.day10.Day10Part2Solver;
import fpc.aoc.year2024.day11.Day11Part1Solver;
import fpc.aoc.year2024.day11.Day11Part2Solver;
import fpc.aoc.year2024.day12.Day12Part1Solver;
import fpc.aoc.year2024.day12.Day12Part2Solver;

module fpc.aoc.year2024 {
  requires static lombok;

  requires fpc.aoc.input;
  requires jakarta.annotation;


  provides Solver with
      Day1Part1Solver, Day1Part2Solver
      , Day2Part1Solver, Day2Part2Solver
      , Day3Part1Solver, Day3Part2Solver
      , Day4Part1Solver, Day4Part2Solver
      , Day5Part1Solver, Day5Part2Solver
      , Day6Part1Solver, Day6Part2Solver
      , Day7Part1Solver, Day7Part2Solver
      , Day8Part1Solver, Day8Part2Solver
      , Day9Part1Solver, Day9Part2Solver
      , Day10Part1Solver, Day10Part2Solver
      , Day11Part1Solver, Day11Part2Solver
      , Day12Part1Solver, Day12Part2Solver
      ;

}