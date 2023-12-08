package fpc.aoc.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day7Test {

  public static final String TEST_INPUT = """
    32T3K 765
    T55J5 684
    KK677 28
    KTJJT 220
    QQQJA 483
    """;

  @Test
  public void testPart1() {
    final var actual = new Day7Part1Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(6440, actual);
  }

  @Test
  public void testPart2() {
    final var actual = new Day7Part2Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(5905, actual);
  }


}
