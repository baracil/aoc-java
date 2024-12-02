package fpc.aoc.launcher._private;

import fpc.aoc.api.RawInput;
import fpc.aoc.api.Solver;
import fpc.aoc.common.NotSolvedYet;
import fpc.aoc.input.SmartRawInput;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.PrintStream;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Launcher {

  public static void launch(Solver solver, RawInput input) {
    new Launcher(solver, input).launch();
  }

  public static void launch(Solver solver) {
    launch(solver, new SmartRawInput(solver.id()));
  }

  @NonNull
  @Getter
  private final Solver solver;
  private final RawInput input;

  private void launch() {
    try {
      final Object solution = solver.solve(input);
      displayMessage(String.valueOf(solution));
    } catch (NotSolvedYet notSolvedYet) {
      displayMessage("Not solved yet");
    } catch (Throwable t) {
      displayError(t);
    }
  }

  private void displayMessage(String message) {
    displayMessage(System.out, message);
  }

  private void displayError(Throwable throwable) {
    displayMessage(System.err, "An error occurred : " + throwable.getMessage());
    throwable.printStackTrace();
  }

  private void displayMessage(PrintStream ps, String message) {
    ps.format("%s %s %s : %s%n", solver.id().year(), solver.id().day(), solver.id().part(), message);
  }

}

