package fpc.aoc.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day02Test {

    public static final String INPUT = """
            A Y
            B X
            C Z
            """;

    @Test
    public void testPart1() {
        final long actual = new Day2Part1Solver().createProblem(INPUT).solve();
        Assertions.assertEquals(15, actual);
    }

    public void testPart2() {
        final long actual = new Day2Part2Solver().createProblem(INPUT).solve();
        Assertions.assertEquals(12, actual);
    }
}
