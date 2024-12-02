package fpc.aoc.year2022.day18;

import fpc.aoc.api.Solver;

import java.util.Set;

//4126 to high
public class Day18Part2Solver extends Day18Solver {

  public static Solver provider() {
    return new Day18Part2Solver();
  }


  @Override
  public Integer doSolve(Set<Face> faces) {
    final var expander = new Expander(faces);
    final var touchedFaces = expander.expand();

    return touchedFaces.size();
  }


}
