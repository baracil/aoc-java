package fpc.aoc.year2019.day11;

import fpc.aoc.api.Solver;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.ProgramBasedSolver;
import fpc.aoc.year2019.day11.computation.Hull;
import fpc.aoc.year2019.day11.computation.Robot;
import lombok.NonNull;

public class Day11Part1Solver extends ProgramBasedSolver {

    public static Solver provider() {
        return new Day11Part1Solver();
    }


    @Override
    protected String doSolve(@NonNull Program program) {
        final Hull hull = new Hull();

        final Robot robot = Robot.create(program);

        robot.placeOnHull(hull);
        robot.switchOn();
        robot.waitUntilDone();
        return ""+robot.numberOfPaintedPanels();
    }
}
