package fpc.aoc.year2020.day18;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day18.structures.ExprEvaluatorTemplate;
import fpc.aoc.year2020.day18.structures.ExpressionEvaluator;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class Day18Solver extends SmartSolver<Stream<String>> {

  @Override
  protected @NonNull Converter<Stream<String>> getConverter() {
    return Converter.TO_STREAM;
  }

  protected abstract @NonNull ExpressionEvaluator createOnePassEvaluator();

  @Override
  public @NonNull Long doSolve(@NonNull Stream<String> input) {
    final var evaluator = new ExprEvaluatorTemplate(createOnePassEvaluator());
    return input.mapToLong(evaluator::evaluate)
        .sum();
  }

}
