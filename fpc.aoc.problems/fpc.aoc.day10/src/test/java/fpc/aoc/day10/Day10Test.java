package fpc.aoc.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Day10Test {

  public static final String TEST_INPUT_PART1_1 = """
    .....
    .S-7.
    .|.|.
    .L-J.
    .....
    """;
  public static final String TEST_INPUT_PART1_2 = """
    ..F7.
    .FJ|.
    SJ.L7
    |F--J
    LJ...
    """;

  public static final String TEST_INPUT_PART2_1 = """
    ...........
    .S-------7.
    .|F-----7|.
    .||.....||.
    .||.....||.
    .|L-7.F-J|.
    .|..|.|..|.
    .L--J.L--J.
    ...........
    """;

  public static final String TEST_INPUT_PART2_2 = """
    .F----7F7F7F7F-7....
    .|F--7||||||||FJ....
    .||.FJ||||||||L7....
    FJL7L7LJLJ||LJ.L-7..
    L--J.L7...LJS7F-7L7.
    ....F-J..F7FJ|L7L7L7
    ....L7.F7||L7|.L7L7|
    .....|FJLJ|FJ|F7|.LJ
    ....FJL-7.||.||||...
    ....L---J.LJ.LJLJ...
    """;

  public static final String TEST_INPUT_PART2_3 = """
    FF7FSF7F7F7F7F7F---7
    L|LJ||||||||||||F--J
    FL-7LJLJ||||||LJL-77
    F--JF--7||LJLJ7F7FJ-
    L---JF-JLJ.||-FJLJJ7
    |F|F-JF---7F7-L7L|7|
    |FFJF7L7F-JF7|JL---7
    7-L-JL7||F7|L7F-7F7|
    L.L7LFJ|||||FJL7||LJ
    L7JLJL-JLJLJL--JLJ.L
    """;

  public static Stream<Arguments> part2() {
    return Stream.of(
      Arguments.of(TEST_INPUT_PART1_1,1),
      Arguments.of(TEST_INPUT_PART2_1,4),
      Arguments.of(TEST_INPUT_PART2_2,8),
      Arguments.of(TEST_INPUT_PART2_3,10)
    );
  }

  @Test
  public void testPart1_1() {
    final var actual = new Day10Part1Solver().createProblem(TEST_INPUT_PART1_1).solve();
    Assertions.assertEquals(4, actual);
  }
  @Test
  public void testPart1_2() {
    final var actual = new Day10Part1Solver().createProblem(TEST_INPUT_PART1_2).solve();
    Assertions.assertEquals(8, actual);
  }


  @ParameterizedTest
  @MethodSource("part2")
  public void testPart2(String map, int expected) {
    final var actual = new Day10Part2Solver().createProblem(map).solve();
    Assertions.assertEquals(expected, actual);
  }


}
