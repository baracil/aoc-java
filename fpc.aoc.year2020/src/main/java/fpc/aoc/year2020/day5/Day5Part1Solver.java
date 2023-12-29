package fpc.aoc.year2020.day5;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day5.structures.BoardingPass;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day5Part1Solver extends Day5Solver<Integer> {

  public static @NonNull Solver provider() {
    return new Day5Part1Solver();
  }

  @Override
  public @NonNull Integer doSolve(@NonNull Stream<BoardingPass> input) {
    return input.mapToInt(BoardingPass::getSeatId).max().orElse(-1);
  }
}
