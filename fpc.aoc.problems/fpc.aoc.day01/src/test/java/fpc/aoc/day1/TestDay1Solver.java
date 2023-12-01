package fpc.aoc.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDay1Solver {

  public static final String TEST_INPUT_1 = """
    1abc2
    pqr3stu8vwx
    a1b2c3d4e5f
    treb7uchet
    """;
  public static final String TEST_INPUT_2 = """
    two1nine
    eightwothree
    abcone2threexyz
    xtwone3four
    4nineeightseven2
    zoneight234
    7pqrstsixteen
    """;

  @Test
  public void testExampleDay1Part1() {
    final var actual = new Day1Part1Solver().createProblem(TEST_INPUT_1).solve();
    Assertions.assertEquals("142", actual);
  }

  @Test
  public void testExampleDay1Part2() {
    final var actual = new Day1Part2Solver().createProblem(TEST_INPUT_2).solve();
    Assertions.assertEquals("281", actual);
  }

}
