package fpc.aoc.year2019.day2;


import fpc.aoc.api.Solver;
import fpc.aoc.computer.Alterations;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.ProgramBasedSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.IntStream;

public class Day2Part2Solver extends ProgramBasedSolver {

  public static Solver provider() {
    return new Day2Part2Solver();
  }

  @Override
  protected Object doSolve(Program program) {
    return new PSolver(program, "19690720").launch().orElseThrow();
  }

  @RequiredArgsConstructor
  private static class PSolver {

    @NonNull
    private final Program program;

    private final String outputTarget;

    @NonNull
    public Optional<String> launch() {
      return IntStream.range(0, 9999)
          .parallel()
          .mapToObj(this::computeResult)
          .filter(r -> r.outputIs(outputTarget))
          .findAny()
          .map(Result::input);

    }

    private Result computeResult(int input) {
      final Alterations alterations = createAlteration(input);
      final String output = program.launchAndWait("Day2 Part2", alterations).getFirstValueOfMemory();
      return new Result(Integer.toString(input), output);
    }

    @NonNull
    private Alterations createAlteration(int nounVerb) {
      final int noun = nounVerb / 100;
      final int verb = nounVerb % 100;
      return Alterations.none().addAlterations(1, Long.toString(noun), Long.toString(verb));
    }

    private record Result(String input, String output) {
      public boolean outputIs(String value) {
        return output.equals(value);
      }
    }

  }

}
