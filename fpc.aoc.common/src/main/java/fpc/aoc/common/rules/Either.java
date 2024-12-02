package fpc.aoc.common.rules;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Either<I, O> implements Rule<I, O> {

  /**
   * @param rule1 the first rule
   * @param rule2 the second rule
   * @return a new rule that returns the validation of one of
   * the provided rules only if one if valid and one is invalid
   */
  public static <I, O> Rule<I, O> oneOf(Rule<I, O> rule1, Rule<I, O> rule2) {
    return new Either<>(rule1, rule2);
  }

  private final Rule<I, O> rule1;
  private final Rule<I, O> rule2;

  @Override
  public Validation<O> validate(I input) {
    final Validation<O> v1 = rule1.validate(input);
    final Validation<O> v2 = rule2.validate(input);

    if (v1.isValid() == v2.isValid()) {
      return Validation.invalid();
    }
    return v1.isValid() ? v1 : v2;
  }
}
