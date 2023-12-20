package fpc.aoc.day19.model;

import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
public class Split<T> {
  private final T ok;
  private final T nok;

  public Optional<T> getOk() {
    return Optional.ofNullable(ok);
  }

  public Optional<T> getNok() {
    return Optional.ofNullable(nok);
  }


  public <U> Split<U> map(Function<? super T, ? extends Optional<U>> mapper) {
    final var newOk = Optional.ofNullable(ok).flatMap(mapper);
    final var newNok = Optional.ofNullable(nok).flatMap(mapper);
    return new Split<>(newOk.orElse(null),newNok.orElse(null));
  }
}
