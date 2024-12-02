package fpc.aoc.year2019.day19;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Position;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.ProgramBasedSolver;
import fpc.aoc.year2019.day19._private.BeamExtract;
import fpc.aoc.year2019.day19._private.BeamSlice;
import fpc.aoc.year2019.day19._private.BeamSliceProbe;

public class Day19Part2Solver extends ProgramBasedSolver {

  public static Solver provider() {
    return new Day19Part2Solver();
  }

  @Override
  protected Object doSolve(Program program) {
    final BeamExtract beamExtract = new BeamExtract(100);
    Position start = Position.of(0, 0);
    do {
      final BeamSlice slice = BeamSliceProbe.probe(program, start);
      beamExtract.push(slice);
      if (beamExtract.canFitTheShip()) {
        return slice.start().x() * 10_000 + (slice.start().y() - 99);
      }
      start = slice.start().down();
    } while (true);

  }
}
