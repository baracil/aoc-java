package fpc.aoc.launcher;

import fpc.aoc.api.Solver;
import fpc.aoc.launcher._private.Launcher;
import fpc.aoc.launcher._private.SolverService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LaunchAll {

    public static void main(String[] args) {
        SolverService.loadSolvers()
                      .sorted(Solver.CHRONOLOGICAL)
                      .forEach(Launcher::launch);
    }

}

