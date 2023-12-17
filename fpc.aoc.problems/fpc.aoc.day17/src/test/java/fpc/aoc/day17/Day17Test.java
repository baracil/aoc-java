package fpc.aoc.day17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day17Test {

  public static final String TEST_INPUT = """
      2413432311323
      3215453535623
      3255245654254
      3446585845452
      4546657867536
      1438598798454
      4457876987766
      3637877979653
      4654967986887
      4564679986453
      1224686865563
      2546548887735
      4322674655533
      """;
  public static final String TEST_INPUT_B = """
      111111111111
      999999999991
      999999999991
      999999999991
      999999999991
      """;

  @Test
  public void testPart1() {
    final var actual = new Day17Part1Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(102, actual);
  }

  @Test
  public void testPart2A() {
    final var actual = new Day17Part2Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(94, actual);
  }

  @Test
  public void testPart2B() {
    final var actual = new Day17Part2Solver().createProblem(TEST_INPUT_B).solve();
    Assertions.assertEquals(71, actual);
  }


}
