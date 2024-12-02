package fpc.aoc.common.rules;

import lombok.RequiredArgsConstructor;

/**
 * a rule that checks its input ends with a specific suffix and
 * return its input with the suffix removed.
 */
@RequiredArgsConstructor
public class StartsWith implements Rule<String, String> {

  public static StartsWith prefix(String prefix) {
    return new StartsWith(prefix);
  }

  private final String suffix;

  @Override
  public Validation<String> validate(String input) {
    if (input.startsWith(suffix)) {
      return Validation.valid(input.substring(suffix.length()));
    }
    return Validation.invalid();
  }
}
