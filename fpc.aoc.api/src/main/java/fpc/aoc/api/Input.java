package fpc.aoc.api;

import lombok.NonNull;

import java.util.function.Function;

public interface Input<I> {

  @NonNull I read();

  default <U> Input<U> map(Function<? super I,? extends U> mapper) {
    return () -> mapper.apply(read());
  }
}
