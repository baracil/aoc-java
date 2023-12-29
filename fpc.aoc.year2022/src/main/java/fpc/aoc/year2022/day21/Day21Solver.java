package fpc.aoc.year2022.day21;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class Day21Solver<T> extends SmartSolver<Group> {

  private final MonkeyEvaluator<T> evaluator;

  @Override
  protected @NonNull Converter<Group> getConverter() {
    return s -> s.stream().map(Monkey::parse)
        .collect(Collectors.collectingAndThen(Collectors.toMap(Monkey::name, m -> m), Group::new));
  }

  @Override
  public @NonNull Long doSolve(@NonNull Group group) {
    final var rootValue = group.getRootValue(evaluator);
    return finalize(rootValue);
  }

  protected abstract Long finalize(T rootResult);
}
