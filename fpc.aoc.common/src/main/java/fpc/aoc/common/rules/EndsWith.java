package fpc.aoc.common.rules;

import lombok.RequiredArgsConstructor;

/**
 * a rule that checks its input ends with a specific suffix and
 * return its input with the suffix removed.
 */
@RequiredArgsConstructor
public class EndsWith implements Rule<String, String> {

  public static EndsWith suffix(String suffix) {
    return new EndsWith(suffix);
  }

  private final String suffix;

  @Override
  public Validation<String> validate(String input) {
    if (input.endsWith(suffix)) {
      return Validation.valid(input.substring(0, input.length() - suffix.length()));
    }
    return Validation.invalid();
  }
}
