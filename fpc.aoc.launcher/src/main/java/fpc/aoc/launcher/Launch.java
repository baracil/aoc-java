package fpc.aoc.launcher;

import fpc.aoc.api.RawInput;
import fpc.aoc.api.Solver;
import fpc.aoc.input.CachedRawInput;
import fpc.aoc.input.SmartRawInput;
import fpc.aoc.launcher._private.Launcher;
import fpc.aoc.launcher._private.SolverService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Launch {

  public static void main(String[] args) {
    final var solver = SolverService.findSolverFromArgs(args);
    final double last = bench(solver, 10, 20);
    System.out.printf("Last : %.3f ms%n", last);
  }

  public static double bench(Solver solver, int warmup, int bench) {
    final var year = solver.id().year();
    final var day = solver.id().day();
    final RawInput input = new CachedRawInput(new SmartRawInput(year, day));
    for (int i = 0; i < warmup; i++) {
      Launcher.launch(solver, input);
    }
    final long start = System.nanoTime();
    for (int i = 0; i < bench; i++) {
      Launcher.launch(solver, input);
    }
    final long last = System.nanoTime() - start;
    return last * 1e-6 / bench;

  }

}

