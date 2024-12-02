package fpc.aoc.common;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class TryResult<T extends Throwable, R> {

  public static <T extends Throwable, R> TryResult<T, R> success(R result) {
    return new TryResult<>(null, result);
  }

  public static <T extends Throwable, R> TryResult<T, R> failure(T error) {
    return new TryResult<>(error, null);
  }

  private final T error;

  private final R result;


  public boolean isSuccess() {
    return error == null;
  }

  public boolean isFailure() {
    return error != null;
  }

  public R getResultOrThrow() throws T {
    if (error != null) {
      throw error;
    }
    return result;
  }

  public Optional<R> getResult() {
    return Optional.ofNullable(result);
  }
}
