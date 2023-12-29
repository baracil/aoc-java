package fpc.aoc.year2022.day9;

import fpc.aoc.common.Position;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public abstract class Day9Solver extends SmartSolver<Stream<Command>> {

  @Override
  protected @NonNull Converter<Stream<Command>> getConverter() {
    return s -> s.stream().map(Command::parse);
  }

  private final int nbKnots;

  public Day9Solver(int nbKnots) {
    this.nbKnots = nbKnots;
  }

  @Override
  public @NonNull Integer doSolve(@NonNull Stream<Command> commands) {
    final Set<Position> visitedPositions = new HashSet<>();
    final var rope = new Rope(nbKnots);
    visitedPositions.add(rope.tailPosition());

    commands.forEach(command -> {
      for (int i = 0; i < command.nbSteps(); i++) {
        rope.moveHead(command.displacement());
        visitedPositions.add(rope.tailPosition());
      }
    });

    return visitedPositions.size();
  }

}
