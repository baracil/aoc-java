package fpc.aoc.day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day11Test {

  public static final String TEST_INPUT = """
    ...#......
    .......#..
    #.........
    ..........
    ......#...
    .#........
    .........#
    ..........
    .......#..
    #...#.....
          """;

  @Test
  public void testPart1() {
    final var actual = new Day11Part1Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(374, actual);
  }


}
