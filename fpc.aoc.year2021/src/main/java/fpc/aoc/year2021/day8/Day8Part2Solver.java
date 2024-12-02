package fpc.aoc.year2021.day8;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day8.struct.Decoder;
import fpc.aoc.year2021.day8.struct.WiringInfo;

import java.util.stream.Stream;

public class Day8Part2Solver extends Day8Solver {

  public static Solver provider() {
    return new Day8Part2Solver();
  }

  @Override
  public Long doSolve(Stream<WiringInfo<String>> input) {
    return input.map(Decoder::decode)
        .mapToLong(WiringInfo::display)
        .sum();

  }
}
