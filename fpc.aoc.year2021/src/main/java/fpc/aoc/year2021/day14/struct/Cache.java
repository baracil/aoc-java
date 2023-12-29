package fpc.aoc.year2021.day14.struct;

import lombok.NonNull;

import java.util.Optional;

public interface Cache {

  @NonNull
  Optional<Distribution> fromCache(@NonNull Couple couple, int generation);

  void saveInCache(@NonNull Couple couple, int generation, @NonNull Distribution distribution);
}
