package fpc.aoc.year2021.day16;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day16.struct.Packet;

public class Day16Part1Solver extends Day16Solver {

  public static Solver provider() {
    return new Day16Part1Solver();
  }

  @Override
  public Long doSolve(Packet packet) {
    return packet.sumOfVersions();
  }

}
