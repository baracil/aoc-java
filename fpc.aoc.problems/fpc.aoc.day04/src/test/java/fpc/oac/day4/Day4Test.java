package fpc.oac.day4;

import fpc.aoc.day4.Day4Part1Solver;
import fpc.aoc.day4.Day4Part2Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day4Test {

  public static final String TEST_INPUT = """
    Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
    Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
    Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
    Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
    Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
    Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11
    """;

  @Test
  public void testPart1() {
    final var actual = new Day4Part1Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals("13", actual);
  }

  @Test
  public void testPart2() {
    final var actual = new Day4Part2Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals("30", actual);
  }


}
