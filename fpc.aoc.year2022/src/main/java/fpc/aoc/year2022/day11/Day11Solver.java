package fpc.aoc.year2022.day11;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.LongUnaryOperator;

@RequiredArgsConstructor
public abstract class Day11Solver extends SmartSolver<MonkeyGame> {


  @Override
  protected Converter<MonkeyGame> getConverter() {
    return s -> s.stream().collect(ParsedMonkeyAgg.collect(this::createPostOperation));
  }


  @Override
  public Long doSolve(MonkeyGame input) {
    for (int i = 0; i < getNumberOfTurns(); i++) {
      input.performOneTurn();
    }
    return input.getMonkeyBusiness();
  }

  protected abstract int getNumberOfTurns();

  protected abstract LongUnaryOperator createPostOperation(List<ParsedMonkey> parsedMonkeys);
}
