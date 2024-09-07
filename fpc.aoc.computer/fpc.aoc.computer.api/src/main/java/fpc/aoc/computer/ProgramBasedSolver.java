package fpc.aoc.computer;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

/**
 * @author Bastien Aracil
 **/
public abstract class ProgramBasedSolver extends SmartSolver<String> {

  @Override
  protected @NonNull Object doSolve(@NonNull String input) {
    final var computer = Computer.create();
    final var program = computer.compile(input);
    return doSolve(program);
  }

  protected abstract Object doSolve(@NonNull Program program);

  @Override
  protected @NonNull Converter<String> getConverter() {
    return Converter.FIRST_LINE;
  }
}
