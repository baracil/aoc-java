package fpc.aoc.day9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day9Test {

  public static final String TEST_INPUT = """
    0 3 6 9 12 15
    1 3 6 10 15 21
    10 13 16 21 30 45
    """;

  @Test
  public void testPart1() {
    final var actual = new Day9Part1Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(114, actual);
  }

  @Test
  public void testPart2() {
    final var actual = new Day9Part2Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(2, actual);
  }


}
