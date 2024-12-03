package fpc.aoc.year2024.day03;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@RequiredArgsConstructor
public abstract class Day3Solver extends SmartSolver<Stream<Operation>> {

  @Override
  protected Converter<Stream<Operation>> getConverter() {
    return Converter.TO_STREAM.andThen(s -> s.flatMap(this::parse));
  }

  @Override
  protected Object doSolve(Stream<Operation> input) {
    return input.reduce(getReducer(), Reducer::handle, Reducer::merge).sum();
  }

  protected abstract Reducer getReducer();


  public static final Pattern MULT_PATTERN = Pattern.compile("(mul\\((?<left>\\d{1,3}),(?<right>\\d{1,3})\\)|do\\(\\)|don't\\(\\))");

  public Stream<Operation> parse(String line) {
    final var matcher = MULT_PATTERN.matcher(line);
    return Stream.<Operation>generate(() -> {
      boolean b = matcher.find();
      if (!b) {
        return null;
      }
      String group = matcher.group();
      String left = matcher.group("left");
      String right = matcher.group("right");
      if (group.startsWith("mul")) {
        return new Operation.Mult(Integer.parseInt(left), Integer.parseInt(right));
      } else if (group.startsWith("don't(")) {
        return new Operation.Dont();
      } else {
        return new Operation.Do();
      }
    }).takeWhile(Objects::nonNull);
  }

}
