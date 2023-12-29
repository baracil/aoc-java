package fpc.aoc.common.rules;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * a rule that checks that its input is at most a specific value and returns its input
 */
@RequiredArgsConstructor
public class IsAtMost implements Rule<Integer, Integer> {

  private final int limit;

  @Override
  public @NonNull Validation<Integer> validate(@NonNull Integer input) {
    if (input <= limit) {
      return Validation.valid(input);
    }
    return Validation.invalid();
  }
}
