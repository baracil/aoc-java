package fpc.aoc.year2020.day24;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day24.structures.HexaPoint;
import fpc.aoc.year2020.day24.structures.Path;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public abstract class Day24Solver extends SmartSolver<Stream<Path>> {

  @Override
  protected @NonNull Converter<Stream<Path>> getConverter() {
    return s -> s.stream().map(Path::parse);
  }

  protected @NonNull Set<HexaPoint> initialBlackTiles(@NonNull Stream<Path> paths) {
    final Set<HexaPoint> blackTiles = new HashSet<>();
    final HexaPoint center = new HexaPoint(0, 0);

    paths.map(p -> p.pointAtEndOfPath(center))
        .forEach(p -> {
          if (!blackTiles.remove(p)) {
            blackTiles.add(p);
          }
        });

    return Set.copyOf(blackTiles);
  }
}
