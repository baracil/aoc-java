package fpc.aoc.day12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day12Test {

  public static final String TEST_INPUT = """
    ???.### 1,1,3
    .??..??...?##. 1,1,3
    ?#?#?#?#?#?#?#? 1,3,1,6
    ????.#...#... 4,1,1
    ????.######..#####. 1,6,5
    ?###???????? 3,2,1
    """;

  @Test
  public void testPart1() {
    final var actual = new Day12Part1Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(21, actual);
  }

  @Test
  public void testPart2() {
    final var actual = new Day12Part2Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals(525152, actual);
  }

  @Test
  public void name() {
    final var row = Row.parse("???.### 1,1,3").unfold();
    System.out.println(ArrangementCounter.count(row));
  }
}
