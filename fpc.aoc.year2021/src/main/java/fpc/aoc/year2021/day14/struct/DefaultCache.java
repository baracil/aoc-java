package fpc.aoc.year2021.day14.struct;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DefaultCache implements Cache {

  private final Map<Couple, Map<Integer, Distribution>> cachedDistributions = new HashMap<>();


  @Override
  public Optional<Distribution> fromCache(Couple couple, int generation) {
    return Optional.ofNullable(cachedDistributions.get(couple)).map(m -> m.get(generation));
  }

  @Override
  public void saveInCache(Couple couple, int generation, Distribution distribution) {
    this.cachedDistributions.computeIfAbsent(couple, c -> new HashMap<>()).put(generation, distribution);
  }
}
