package fpc.aoc.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day02Test {

  public static final String INPUT = """
    Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
    Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
    Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
    Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
    Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
    """;

  @Test
  public void testPart1() {
    final var actual = new Day2Part1Solver().createProblem(INPUT).solve();
    Assertions.assertEquals(8, actual);
  }

  @Test
  public void testPart2() {
    final var actual = new Day2Part2Solver().createProblem(INPUT).solve();
    Assertions.assertEquals(2286, actual);
  }
}
