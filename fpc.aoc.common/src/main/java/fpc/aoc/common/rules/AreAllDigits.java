package fpc.aoc.common.rules;

import lombok.NonNull;

/**
 * A rule that checks that all char are digits and return its input
 */
public class AreAllDigits implements Rule<String, String> {

  public static AreAllDigits create() {
    return new AreAllDigits();
  }

  @Override
  public @NonNull Validation<String> validate(@NonNull String input) {
    if (input.chars().allMatch(i -> i >= '0' && i <= '9')) {
      return Validation.valid(input);
    }
    return Validation.invalid();
  }
}
