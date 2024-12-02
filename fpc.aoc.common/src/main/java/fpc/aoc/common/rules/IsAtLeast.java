package fpc.aoc.common.rules;

import lombok.RequiredArgsConstructor;

/**
 * a rule that checks that its input is at leas a specific value and returns its input
 */
@RequiredArgsConstructor
public class IsAtLeast implements Rule<Integer, Integer> {

  private final int limit;

  @Override
  public Validation<Integer> validate(Integer input) {
    if (input >= limit) {
      return Validation.valid(input);
    }
    return Validation.invalid();
  }
}
