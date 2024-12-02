package fpc.aoc.api;

import java.util.function.Function;

public interface Input<I> {

  I read();

  default <U> Input<U> map(Function<? super I, ? extends U> mapper) {
    return () -> mapper.apply(read());
  }
}
