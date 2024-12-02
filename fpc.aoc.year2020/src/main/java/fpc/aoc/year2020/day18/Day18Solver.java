package fpc.aoc.year2020.day18;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day18.structures.ExprEvaluatorTemplate;
import fpc.aoc.year2020.day18.structures.ExpressionEvaluator;

import java.util.stream.Stream;

public abstract class Day18Solver extends SmartSolver<Stream<String>> {

  @Override
  protected Converter<Stream<String>> getConverter() {
    return Converter.TO_STREAM;
  }

  protected abstract ExpressionEvaluator createOnePassEvaluator();

  @Override
  public Long doSolve(Stream<String> input) {
    final var evaluator = new ExprEvaluatorTemplate(createOnePassEvaluator());
    return input.mapToLong(evaluator::evaluate)
        .sum();
  }

}
