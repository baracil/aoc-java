package fpc.aoc.year2022.day25;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.math.BigInteger;
import java.util.stream.Stream;

public abstract class Day25Solver extends SmartSolver<Stream<BigInteger>> {

  @Override
  protected @NonNull Converter<Stream<BigInteger>> getConverter() {
    return s -> s.stream().map(Snafu::toValue);
  }

}
