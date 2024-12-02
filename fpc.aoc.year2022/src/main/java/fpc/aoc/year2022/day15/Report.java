package fpc.aoc.year2022.day15;

import fpc.aoc.common.AOCException;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class Report {

  private final List<SensorReport> reports;


  public long computePart1(int lineIndex) {
    return this.lineCoverage(lineIndex, l -> true)
        .stream()
        .mapToInt(LineCoverage::nbNotDetected)
        .sum();
  }

  public long computePart2(int sup) {
    final var lst = IntStream.rangeClosed(0, sup)
        .mapToObj(i -> this.lineCoverage(i, l -> l.doesNotFullyCover(0, sup)))
        .parallel()
        .filter(l -> !l.isEmpty())
        .findAny().orElseThrow(() -> new AOCException("Cannot solve this"));
    return lst.getFirst().lineIndex() + (lst.getFirst().sup() + 1) * 4000000L;
  }


  private List<LineCoverage> lineCoverage(int lineIndex, Predicate<LineCoverage> keep) {
    final var lineCoverages = reports.stream()
        .map(r -> r.getCoverage(lineIndex))
        .flatMap(Optional::stream)
        .sorted(Comparator.comparingInt(LineCoverage::inf))
        .toList();

    if (lineCoverages.isEmpty()) {
      return List.of();
    }


    final List<LineCoverage> coverage = new ArrayList<>();
    var current = lineCoverages.getFirst();
    for (int i = 1; i < lineCoverages.size(); i++) {
      final var next = lineCoverages.get(i);
      final var merged = current.merge(next);

      if (merged == null) {
        if (keep.test(current)) {
          coverage.add(current);
        }
        current = next;
      } else {
        current = merged;
      }
    }
    if (keep.test(current)) {
      coverage.add(current);
    }

    return coverage;

  }
}
