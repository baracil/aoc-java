package fpc.aoc.common.rules;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * a rule that checks its input ends with a specific suffix and
 * return its input with the suffix removed.
 */
@RequiredArgsConstructor
public class StartsWith implements Rule<String, String> {

  public static StartsWith prefix(@NonNull String prefix) {
    return new StartsWith(prefix);
  }

  private final @NonNull String suffix;

  @Override
  public @NonNull Validation<String> validate(@NonNull String input) {
    if (input.startsWith(suffix)) {
      return Validation.valid(input.substring(suffix.length(), input.length()));
    }
    return Validation.invalid();
  }
}
