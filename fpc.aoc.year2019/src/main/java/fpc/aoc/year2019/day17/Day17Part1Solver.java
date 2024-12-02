package fpc.aoc.year2019.day17;

import fpc.aoc.api.Solver;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.ProgramBasedSolver;
import fpc.aoc.year2019.day17._private.Camera;
import fpc.aoc.year2019.day17._private.Intersections;

public class Day17Part1Solver extends ProgramBasedSolver {

    public static Solver provider() {
        return new Day17Part1Solver();
    }

    @Override
    protected Object doSolve(Program program) {
        final var camera = new Camera(program);
        return "" + Intersections.findOnPicture(camera.takePicture()).sumOfAlignments();
    }
}
