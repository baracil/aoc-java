package fpc.aoc.day14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day14Test {

  public static final String TEST_INPUT = """
    O....#....
    O.OO#....#
    .....##...
    OO.#O....O
    .O.....O#.
    O.#..O.#.#
    ..O..#O..O
    .......O..
    #....###..
    #OO..#....
    """;

  @Test
  public void testPart1() {
    final var actual = new Day14Part1Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(136, actual);
  }

  @Test
  public void testPart2() {
    final var actual = new Day14Part2Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(64, actual);
  }


}
