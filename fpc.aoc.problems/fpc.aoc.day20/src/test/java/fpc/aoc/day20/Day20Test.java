package fpc.aoc.day20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day20Test {

  public static final String TEST_INPUT_1 = """
      broadcaster -> a, b, c
      %a -> b
      %b -> c
      %c -> inv
      &inv -> a
      """;
  public static final String TEST_INPUT_2 = """
      broadcaster -> a
      %a -> inv, con
      &inv -> b
      %b -> con
      &con -> output
      """;

  @Test
  public void testPart1A() {
    final var actual = new Day20Part1Solver().createProblem(TEST_INPUT_1).solve();
    Assertions.assertEquals(32000000, actual);
  }
  @Test
  public void testPart1B() {
    final var actual = new Day20Part1Solver().createProblem(TEST_INPUT_2).solve();
    Assertions.assertEquals(11687500, actual);
  }

  @Test
  public void testPart2() {
    final var actual = new Day20Part2Solver().createProblem(TEST_INPUT_1).solve();
    Assertions.assertEquals("1924", actual);
  }


}
