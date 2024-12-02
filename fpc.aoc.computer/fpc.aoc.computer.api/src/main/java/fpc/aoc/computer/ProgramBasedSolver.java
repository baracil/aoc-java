package fpc.aoc.computer;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

/**
 * @author Bastien Aracil
 **/
public abstract class ProgramBasedSolver extends SmartSolver<String> {

  @Override
  protected Object doSolve(String input) {
    final var computer = Computer.create();
    final var program = computer.compile(input);
    return doSolve(program);
  }

  protected abstract Object doSolve(Program program);

  @Override
  protected Converter<String> getConverter() {
    return Converter.FIRST_LINE;
  }
}
