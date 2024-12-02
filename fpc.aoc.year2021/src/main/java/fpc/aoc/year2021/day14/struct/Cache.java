package fpc.aoc.year2021.day14.struct;

import lombok.NonNull;

import java.util.Optional;

public interface Cache {

  @NonNull
  Optional<Distribution> fromCache(Couple couple, int generation);

  void saveInCache(Couple couple, int generation, Distribution distribution);
}
