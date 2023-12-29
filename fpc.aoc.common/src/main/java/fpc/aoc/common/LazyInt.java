package fpc.aoc.common;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.IntSupplier;

@RequiredArgsConstructor
public class LazyInt extends Number {

  private final AtomicReference<Integer> reference = new AtomicReference<>();

  private final @NonNull IntSupplier computer;

  @Override
  public int intValue() {
    return reference.updateAndGet(i -> i == null ? computer.getAsInt() : i);
  }

  @Override
  public long longValue() {
    return intValue();
  }

  @Override
  public float floatValue() {
    return intValue();
  }

  @Override
  public double doubleValue() {
    return intValue();
  }
}
