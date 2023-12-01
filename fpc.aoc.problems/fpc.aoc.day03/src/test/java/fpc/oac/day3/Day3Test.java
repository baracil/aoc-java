package fpc.oac.day3;

import fpc.aoc.common.Tools;
import fpc.aoc.day3.Day3Part1Solver;
import fpc.aoc.day3.Day3Part2Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day3Test {

    public static final String INPUT = """
            """;

    @Test
    public void testExamplePart1() {
        final var actual = new Day3Part1Solver().createProblem(INPUT).solve();
        Assertions.assertEquals(Tools.TODO(),actual);
    }

    @Test
    public void testExamplePart2() {
        final var actual = new Day3Part2Solver().createProblem(INPUT).solve();
        Assertions.assertEquals(Tools.TODO(),actual);
    }


}
