package fpc.aoc.launcher;

import fpc.aoc.launcher._private.Launcher;
import fpc.aoc.launcher._private.ProblemService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import fpc.aoc.api.Day;

@RequiredArgsConstructor
public class LaunchLastDay {

    public static void main(String[] args) {
        ProblemService.findLastDay()
                      .map(LaunchLastDay::new)
                      .ifPresentOrElse(LaunchLastDay::launch, () -> System.err.println("No problem found"));

    }

    private final @NonNull Day day;

    public void launch() {
        ProblemService.listProblemsOfADay(day)
                      .forEach(Launcher::launch);
    }

}

