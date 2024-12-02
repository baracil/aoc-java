package fpc.aoc.year2019.day7;

import fpc.aoc.api.Solver;
import fpc.aoc.computer.Program;

public class Day7Part1Solver extends Day7Solver {

  public static Solver provider() {
    return new Day7Part1Solver();
  }


  @Override
  protected Circuit createCircuit(Program program) {
    return new LinearCircuit(program);
  }

  @Override
  protected String[] phaseValues() {
    return new String[]{"0", "1", "2", "3", "4"};
  }

}
