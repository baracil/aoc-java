package fpc.aoc.day16;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.Orientation;
import fpc.aoc.day16.model.BeamComputer;
import lombok.NonNull;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day16Part2Solver extends Day16Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day16Part2Solver().createProblem();
  }


  @Override
  public @NonNull Long solve(@NonNull BeamComputer input) {
    final var height = input.height();
    final var width = input.width();


    return Stream.of(
            IntStream.range(0, width).mapToObj(x -> new Beam(x, 0, Orientation.S)),
            IntStream.range(0, width).mapToObj(x -> new Beam(x, height - 1, Orientation.N)),
            IntStream.range(0, height).mapToObj(y -> new Beam(0, y, Orientation.E)),
            IntStream.range(0, height).mapToObj(y -> new Beam(width - 1, y, Orientation.W))
        )
        .parallel()
        .flatMap(s -> s)
        .mapToLong(input::compute).max().orElse(0);

  }
}
