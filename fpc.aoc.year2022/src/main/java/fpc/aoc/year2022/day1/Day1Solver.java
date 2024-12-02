package fpc.aoc.year2022.day1;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

import java.util.stream.LongStream;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public abstract class Day1Solver extends SmartSolver<LongStream> {

  @Override
  protected Converter<LongStream> getConverter() {
    return list -> {
      final var caloryList = new CarriedCalory(list);
      return StreamSupport.stream(caloryList.spliterator(), false).mapToLong(l -> l);
    };
  }


}
