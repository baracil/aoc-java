package fpc.aoc.common;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class TryResult<T extends Throwable, R> {

  public static <T extends Throwable, R> @NonNull TryResult<T, R> success(@NonNull R result) {
    return new TryResult<>(null, result);
  }

  public static <T extends Throwable, R> @NonNull TryResult<T, R> failure(@NonNull T error) {
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

  public @NonNull R getResultOrThrow() throws T {
    if (error != null) {
      throw error;
    }
    return result;
  }

  public @NonNull Optional<R> getResult() {
    return Optional.ofNullable(result);
  }
}
