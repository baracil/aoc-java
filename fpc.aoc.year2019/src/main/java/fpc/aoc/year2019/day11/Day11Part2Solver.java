package fpc.aoc.year2019.day11;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Position;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.ProgramBasedSolver;
import fpc.aoc.year2019.day11.computation.Color;
import fpc.aoc.year2019.day11.computation.Hull;
import fpc.aoc.year2019.day11.computation.Robot;

import java.util.stream.Collectors;

public class Day11Part2Solver extends ProgramBasedSolver {

    public static Solver provider() {
        return new Day11Part2Solver();
    }


    @Override
    protected String doSolve(Program program) {
        final Hull hull = new Hull();
        final Robot robot = Robot.create(program);

        hull.paint(Position.of(0,0), Color.WHITE);

        robot.placeOnHull(hull);
        robot.switchOn();
        robot.waitUntilDone();



        return hull.dump().stream().collect(Collectors.joining("\n","\n",""));
    }
}
