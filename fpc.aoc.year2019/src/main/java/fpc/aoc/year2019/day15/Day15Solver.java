package fpc.aoc.year2019.day15;

import fpc.aoc.common.Orientation;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.ProgramBasedSolver;
import fpc.aoc.robot.Controller;
import fpc.aoc.robot.Robot;
import fpc.aoc.year2019.day15.computation.DroidState;
import fpc.aoc.year2019.day15.computation.DroidStateUpdater;
import fpc.aoc.year2019.day15.computation.MapperController;

public abstract class Day15Solver extends ProgramBasedSolver {

  @Override
  protected Object doSolve(Program program) {
    final Controller<Orientation, DroidState> controller = new MapperController();
    final Robot<DroidState> robot = Robot.create(program, new DroidStateUpdater(), controller);

    robot.switchOn();
    robot.waitForShutdown();

    DroidState state = robot.getState();

    return solve(state);
  }

  abstract int solve(DroidState droidState);
}
