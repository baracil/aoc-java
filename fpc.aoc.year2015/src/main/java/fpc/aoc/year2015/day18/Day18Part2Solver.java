package fpc.aoc.year2015.day18;

import fpc.aoc.api.Solver;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.GameOfLife;
import fpc.aoc.common.Point2D;

import java.util.Set;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day18Part2Solver extends Day18Solver {

  public static Solver provider() {
    return new Day18Part2Solver();
  }


  @Override
  public Integer doSolve(ArrayOfChar input) {
    final var limit = input.width();

    final var startingPoints = Stream.concat(
        input.where('#', Point2D::new),
        corners(limit)
    ).collect(Collectors.toSet());

    final var gol = GameOfLife.initialize(startingPoints, new Rule(limit), getFinalizer(limit));

    gol.performCycles(100);
    return gol.numberOfActiveCells();


  }

  private UnaryOperator<Set<Point2D>> getFinalizer(int limit) {
    final var points = corners(limit).toList();
    return s -> {
      s.addAll(points);
      return s;
    };
  }

  private Stream<Point2D> corners(int limit) {
    return Stream.of(
        new Point2D(0, 0),
        new Point2D(0, limit - 1),
        new Point2D(limit - 1, 0),
        new Point2D(limit - 1, limit - 1));
  }
}
