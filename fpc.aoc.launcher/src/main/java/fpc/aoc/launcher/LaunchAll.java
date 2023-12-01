package fpc.aoc.launcher;

import fpc.aoc.launcher._private.Launcher;
import fpc.aoc.launcher._private.ProblemService;
import lombok.RequiredArgsConstructor;
import fpc.aoc.api.AOCProblem;

@RequiredArgsConstructor
public class LaunchAll {

    public static void main(String[] args) {
        ProblemService.loadProblems()
                      .sorted(AOCProblem::compareTo)
                      .forEach(Launcher::launch);
    }

}

