package fpc.aoc.common.rules;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * a rule that checks its input ends with a specific suffix and
 * return its input with the suffix removed.
 */
@RequiredArgsConstructor
public class EndsWith implements Rule<String, String> {

  public static EndsWith suffix(@NonNull String suffix) {
    return new EndsWith(suffix);
  }

  private final @NonNull String suffix;

  @Override
  public @NonNull Validation<String> validate(@NonNull String input) {
    if (input.endsWith(suffix)) {
      return Validation.valid(input.substring(0, input.length() - suffix.length()));
    }
    return Validation.invalid();
  }
}
