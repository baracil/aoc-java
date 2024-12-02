package fpc.aoc.year2019.day3;

import fpc.aoc.common.AOCException;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.Arrays;
import java.util.List;

public abstract class BaseDay3Solver extends SmartSolver<List<Path>> {

  @Override
  protected Converter<List<Path>> getConverter() {
    return Converter.forItem(this::convertOneLine);
  }

  @Override
  protected Object doSolve(List<Path> input) {
    final Path path1 = input.get(0);
    final Path path2 = input.get(1);

    return compute(path1, path2);
  }

  protected abstract int compute(Path path1, Path path2);


  @NonNull
  private Path convertOneLine(String line) {
    return Arrays.stream(line.split(","))
        .map(Movement::parse)
        .sequential()
        .reduce(new Path(), Path::complete, (p1, p2) -> {
          throw new AOCException("Cannot combine path");
        });
  }
}
