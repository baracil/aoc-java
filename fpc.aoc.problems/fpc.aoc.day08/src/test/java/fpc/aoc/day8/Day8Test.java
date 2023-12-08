package fpc.aoc.day8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day8Test {

  public static final String TEST_INPUT_PART1 = """
    LLR
        
    AAA = (BBB, BBB)
    BBB = (AAA, ZZZ)
    ZZZ = (ZZZ, ZZZ)
    """;

  public static final String TEST_INPUT_PART2 = """
    LR

    11A = (11B, XXX)
    11B = (XXX, 11Z)
    11Z = (11B, XXX)
    22A = (22B, XXX)
    22B = (22C, 22C)
    22C = (22Z, 22Z)
    22Z = (22B, 22B)
    XXX = (XXX, XXX)
    """;


  @Test
  public void testPart1() {
    final var actual = new Day8Part1Solver().createProblem(TEST_INPUT_PART1).solve();
    Assertions.assertEquals("6", actual);
  }

  @Test
  public void testPart2() {
    final var actual = new Day8Part2Solver().createProblem(TEST_INPUT_PART2).solve();
    Assertions.assertEquals("6", actual);
  }


}
