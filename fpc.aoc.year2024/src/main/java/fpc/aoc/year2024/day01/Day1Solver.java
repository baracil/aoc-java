package fpc.aoc.year2024.day01;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public abstract class Day1Solver extends SmartSolver<List<Pair>> {

  @Override
  protected Converter<List<Pair>> getConverter() {
    return Converter.IDENTITY.andThen(Day1Solver::toListOfPair);
  }


  public static List<Pair> toListOfPair(List<String> lines) {
    final var pairs = new ArrayList<Pair>(lines.size());
    for (int i = 0; i < lines.size(); i++) {
      final var tokens = lines.get(i).split(" +");
      final var pair = new Pair(i, Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
      pairs.add(pair);
    }
    return pairs;
  }


}
