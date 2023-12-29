package fpc.aoc.year2020.day8;

import fpc.aoc.api.Solver;
import fpc.aoc.common.AOCException;
import fpc.aoc.common.Tools;
import fpc.aoc.year2020.day8.structures.*;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day8Part2Solver extends Day8Solver {

  public static @NonNull Solver provider() {
    return new Day8Part2Solver();
  }

  @Override
  public @NonNull Integer doSolve(@NonNull Program program) {
    return streamProgramCandidates(program.code())
        .map(this::execute)
        .flatMap(Optional::stream)
        .findFirst()
        .orElseThrow(() -> new AOCException("You are too stupid to solve this"))
        .accumulator();
  }

  private @NonNull Optional<ExecutionContext> execute(Program program) {
    return Processor.with(Part2StopCondition.createFor(program))
        .launch(program)
        .getResult();
  }

  private @NonNull Stream<Program> streamProgramCandidates(@NonNull List<Instruction> originalCode) {
    return IntStream.range(0, originalCode.size())
        .filter(i -> originalCode.get(i).getOperation() != Operation.ACC)
        .mapToObj(i -> alterCode(originalCode, i));
  }

  private @NonNull Program alterCode(
      @NonNull List<Instruction> originalCode,
      int alterationIndex) {
    final var alteredCode = Tools.replaceAt(originalCode, alterationIndex, Instruction::mutate);
    return new Program(alteredCode);
  }
}
