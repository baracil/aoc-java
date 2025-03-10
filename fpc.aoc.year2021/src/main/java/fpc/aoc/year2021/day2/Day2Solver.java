package fpc.aoc.year2021.day2;

import fpc.aoc.common.SubCommand;
import fpc.aoc.common.Submarine;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

import java.util.function.BiFunction;
import java.util.stream.Stream;

@RequiredArgsConstructor
public abstract class Day2Solver extends SmartSolver<Stream<SubCommand>> {

  private final BiFunction<Submarine, ? super SubCommand, Submarine> commandExecutor;

  @Override
  protected Converter<Stream<SubCommand>> getConverter() {
    return s -> s.stream().map(SubCommand::parse);
  }

  @Override
  public Long doSolve(Stream<SubCommand> input) {
    final Submarine finalPosition = input.sequential()
        .reduce(
            Submarine.startPosition(),

            commandExecutor,
            (s1, s2) -> {
              throw new UnsupportedOperationException();
            });

    return (long) (finalPosition.horizontal() * finalPosition.depth());

  }

}
