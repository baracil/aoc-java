package fpc.aoc.launcher;

import fpc.aoc.api.DayId;
import fpc.aoc.api.Year;
import fpc.aoc.launcher._private.Launcher;
import fpc.aoc.launcher._private.SolverService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class LaunchLastDay {

  public static void main(String[] args) {
    final Optional<DayId> dayId;
    if (args.length == 0) {
      dayId = SolverService.findLastDay();
    } else {
      dayId = SolverService.findLastDay(Year.parse(args[0]));
    }
    dayId
        .map(LaunchLastDay::new)
        .ifPresentOrElse(LaunchLastDay::launch, () -> System.err.println("No problem found"));

  }

  private final DayId dayId;

  public void launch() {
    SolverService.loadSolversOfADay(dayId)
        .forEach(Launcher::launch);
  }

}

