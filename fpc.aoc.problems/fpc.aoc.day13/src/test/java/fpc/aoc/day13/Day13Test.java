package fpc.aoc.day13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day13Test {

  public static final String TEST_INPUT = """
    #.##..##.
    ..#.##.#.
    ##......#
    ##......#
    ..#.##.#.
    ..##..##.
    #.#.##.#.

    #...##..#
    #....#..#
    ..##..###
    #####.##.
    #####.##.
    ..##..###
    #....#..#
    """;

  public static final String TEST_INPUT_2 = """
    ....
    ####
    ....
    ....
    ####
        
    ####
    ....
    ....
    ####
    ....
    """;

  public static final String TEST_INPUT_3 = """
    ....
    .###
    ....
    ....
    ####
        
    ####
    ....
    ....
    ##.#
    ....
    """;

  @Test
  public void testPart1() {
    final var actual = new Day13Part1Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(405, actual);
  }

  @Test
  public void testPart1_2() {
    final var actual = new Day13Part1Solver().createProblem(TEST_INPUT_2).solve();
    Assertions.assertEquals(500, actual);
  }

  @Test
  public void testPart2() {
    final var actual = new Day13Part2Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(400, actual);
  }

  @Test
  public void testPart2_2() {
    final var actual = new Day13Part2Solver().createProblem(TEST_INPUT_3).solve();
    Assertions.assertEquals(500, actual);
  }


}
