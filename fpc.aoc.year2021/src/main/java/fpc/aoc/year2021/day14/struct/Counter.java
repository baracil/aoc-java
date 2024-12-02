package fpc.aoc.year2021.day14.struct;

import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

@RequiredArgsConstructor
public class Counter {

  private final String template;
  private final Rules rules;
  private final Cache cache = new DefaultCache();

  public long compute(int generation) {
    return IntStream.range(0, template.length() - 1)
        .mapToObj(i -> new Couple(template.charAt(i), template.charAt(i + 1)))
        .map(c -> count(c, generation))
        .reduce((d1, d2) -> {
          return d1.add(d2);
        })
        .orElseThrow()
        .getAmplitude();
  }

  private Distribution count(Couple couple, int generation) {
    return cache.fromCache(couple, generation).orElseGet(() -> computeDistribution(couple, generation));
  }

  private Distribution computeDistribution(Couple couple, int generation) {
    final Character middle = rules.getInsertion(couple).orElse(null);

    final Distribution distribution;
    if (middle == null || generation == 0) {
      distribution = Distribution.singleCouple(couple);
    } else {
      distribution = couple.split(middle)
          .map(c -> count(c, generation - 1))
          .reduce(Distribution::add)
          .orElseThrow();
    }

    cache.saveInCache(couple, generation, distribution);

    return distribution;
  }
}
