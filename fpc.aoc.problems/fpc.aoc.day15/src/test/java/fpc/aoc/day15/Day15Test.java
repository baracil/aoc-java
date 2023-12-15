package fpc.aoc.day15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day15Test {

    public static final String TEST_INPUT = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7";

    @Test
    public void testPart1() {
        final var actual = new Day15Part1Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(1320,actual);
    }

    @Test
    public void testPart2() {
        final var actual = new Day15Part2Solver().createProblem(TEST_INPUT).solve();
        Assertions.assertEquals(145,actual);
    }


}
