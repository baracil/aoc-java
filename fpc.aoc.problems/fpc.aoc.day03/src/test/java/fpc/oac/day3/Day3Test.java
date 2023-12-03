package fpc.oac.day3;

import fpc.aoc.day3.Day3Part1Solver;
import fpc.aoc.day3.Day3Part2Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day3Test {

  public static final String INPUT = """
    467..114..
    ...*......
    ..35..633.
    ......#...
    617*......
    .....+.58.
    ..592.....
    ......755.
    ...$.*....
    .664.598..
    """;

  @Test
  public void testExamplePart1() {
    final var actual = new Day3Part1Solver().createProblem(INPUT).solve();
    Assertions.assertEquals(4361, actual);
  }

  @Test
  public void testExamplePart2() {
    final var actual = new Day3Part2Solver().createProblem(INPUT).solve();
    Assertions.assertEquals(467835, actual);
  }


}
