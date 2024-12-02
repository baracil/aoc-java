package fpc.aoc.year2019.day7;

import fpc.aoc.common.AOCException;
import fpc.aoc.computer.Execution;
import fpc.aoc.computer.ExecutionResult;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.io.Pipe;
import fpc.aoc.computer.io.ProgramIO;
import fpc.aoc.computer.io.ProgramInput;
import fpc.aoc.computer.io.ProgramOutput;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class CircuitWithFeedback implements Circuit {

  @NonNull
  private final Program program;

  @Override
  @NonNull
  public String launch(Phase phase) {
    final Launcher launcher = new Launcher(phase);
    final ExecutionResult results = launcher.launch();

    return results.getLastOutput();
  }

  private class Launcher {

    @NonNull
    private final Phase phase;

    private final int nbAmplifiers;

    private Pipe[] pipes;

    private List<Execution<ProgramInput<String>, ProgramOutput<String>>> executions;

    public Launcher(Phase phase) {
      this.phase = phase;
      this.nbAmplifiers = phase.size();
    }

    public ExecutionResult launch() {
      this.launchAllPrograms();
      this.initializeInputs();
      this.linkIOOffAmplifiers();

      return this.retrieveAllResults().get(nbAmplifiers - 1);
    }

    private void linkIOOffAmplifiers() {
      final Pipe[] pipes = new Pipe[nbAmplifiers];

      for (int current = 0; current < executions.size(); current++) {
        final int next = (current + 1) % nbAmplifiers;

        final ProgramOutput<String> currentOutput = executions.get(current).programOutputAccessor();
        final ProgramInput<String> nextInput = executions.get(next).programInputAccessor();

        pipes[current] = currentOutput.pipeTo(nextInput);
      }

      this.pipes = pipes;
    }

    private void initializeInputs() {
      for (int i = 0; i < nbAmplifiers; i++) {
        executions.get(i).programInputAccessor().write(phase.get(i));
      }
      executions.getFirst().programInputAccessor().write("0");
    }

    private void launchAllPrograms() {
      this.executions = IntStream.range(0, nbAmplifiers)
          .mapToObj(i -> "Amp " + i)
          .map(name -> program.launch(name, ProgramIO.duplex()))
          .toList();
    }

    private List<ExecutionResult> retrieveAllResults() {
      try {
        return executions.stream()
            .map(e -> {
              try {
                return e.waitTermination();
              } catch (Throwable ex) {
                throw new AOCException("Processor failed", ex);
              }
            }).toList();
      } finally {
        Arrays.stream(pipes).forEach(Pipe::close);
      }
    }


  }


}
