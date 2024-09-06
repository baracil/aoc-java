package fpc.aoc.year2019.day7;

import fpc.aoc.computer.ExecutionResult;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.io.ProgramIO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LinearCircuit implements Circuit {

  @NonNull
  private final Program program;

  @NonNull
  public String launch(@NonNull Phase phase) {
    final int nbAmplifiers = phase.size();
    String result = "0";
    for (int i = 0; i < nbAmplifiers; i++) {
      final ExecutionResult executionResult = program.launchAndWait("Amp " + (i + 1),
          ProgramIO.fromList(phase.get(i), result)
              .ignoreOutput()
      );
      result = executionResult.getLastOutput();
    }

    return result;
  }

}
