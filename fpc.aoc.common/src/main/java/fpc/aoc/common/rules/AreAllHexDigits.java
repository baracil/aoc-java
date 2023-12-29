package fpc.aoc.common.rules;

import lombok.NonNull;

/**
 * A rule that checks that all char are hexa-digits and return its input
 */
public class AreAllHexDigits implements Rule<String, String> {

  public static AreAllHexDigits create() {
    return new AreAllHexDigits();
  }

  @Override
  public @NonNull Validation<String> validate(@NonNull String input) {
    if (input.chars().allMatch(this::isHexDigit)) {
      return Validation.valid(input);
    }
    return Validation.invalid();
  }

  private boolean isHexDigit(int character) {
    return (character >= '0' && character <= '9') || (character >= 'a' && character <= 'f');
  }
}
