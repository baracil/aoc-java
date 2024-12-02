package fpc.aoc.year2020.day14;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day14.structures.Instruction;
import fpc.aoc.year2020.day14.structures.Memory;

import java.util.List;

public abstract class Day14Solver extends SmartSolver<List<Instruction>> {

  @Override
  protected Converter<List<Instruction>> getConverter() {
    return Converter.forItem(Instruction::parse);
  }

  protected abstract Memory createMemory();

  @Override
  public final Long doSolve(List<Instruction> input) {
    final Memory memory = createMemory();
    input.forEach(i -> i.applyToMemory(memory));
    return memory.sumOfAllValues();
  }

}
