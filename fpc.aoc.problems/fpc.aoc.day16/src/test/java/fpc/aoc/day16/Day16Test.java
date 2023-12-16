package fpc.aoc.day16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day16Test {

  public static final String TEST_INPUT = """
      .|...\\....
      |.-.\\.....
      .....|-...
      ........|.
      ..........
      .........\\
      ..../.\\\\..
      .-.-/..|..
      .|....-|.\\
      ..//.|....
      """;

  @Test
  public void testPart1() {
    final var actual = new Day16Part1Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(46, actual);
  }

  @Test
  public void testPart2() {
    final var actual = new Day16Part2Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(51, actual);
  }


}
