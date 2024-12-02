package fpc.aoc.common.rules;

public interface Rule<I, O> {

  /**
   * validate the input by using this rule
   *
   * @param input the input to validate
   * @return a {@link Validation} that contain the result of the validation if valid, otherwise an
   * invalid validation (without any data)
   */
  Validation<O> validate(I input);

  /**
   * Chain a rule
   *
   * @param after the rule to validate
   * @param <P>   the type of data the provided rule returns
   * @return a new rule that chain this rule with the one provided
   */
  default <P> Rule<I, P> and(Rule<? super O, P> after) {
    return i -> this.validate(i).map(after);
  }

  static Rule<String, Integer> isFourDigitsBetween(int limitInf, int limitSup) {
    return HasSize.of(4).and(isIntegerBetween(limitInf, limitSup));
  }

  static Rule<String, Integer> isIntegerBetween(int limitInf, int limitSup) {
    return IsInteger.create()
        .and(new IsAtLeast(limitInf))
        .and(new IsAtMost(limitSup));
  }

  static <I> Rule<I, I> alwaysValid() {
    return Validation::valid;
  }


}
