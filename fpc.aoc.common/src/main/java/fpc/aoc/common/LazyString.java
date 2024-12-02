package fpc.aoc.common;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class LazyString implements CharSequence {

  public static LazyString of(Supplier<? extends CharSequence> heavyComputation) {
    return new LazyString(heavyComputation);
  }

  private final AtomicReference<CharSequence> value = new AtomicReference<>(null);

  private final Supplier<? extends CharSequence> heavyComputation;

  @Override
  public int length() {
    return getValue().length();
  }

  @Override
  public char charAt(int index) {
    return getValue().charAt(index);
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    return getValue().subSequence(start, end);
  }

  @Override
  public String toString() {
    return getValue().toString();
  }

  private CharSequence getValue() {
    return value.updateAndGet(c -> c == null ? heavyComputation.get() : c);
  }
}
