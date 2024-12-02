package fpc.aoc.common.rules;

import lombok.RequiredArgsConstructor;

/**
 * A rule that checks that the input has a specific size and returns its input
 */
@RequiredArgsConstructor
public class HasSize implements Rule<String, String> {

  public static HasSize of(int size) {
    return new HasSize(size);
  }

  private final int size;

  @Override
  public Validation<String> validate(String input) {
    if (input.length() == size) {
      return Validation.valid(input);
    }
    return Validation.invalid();
  }
}
