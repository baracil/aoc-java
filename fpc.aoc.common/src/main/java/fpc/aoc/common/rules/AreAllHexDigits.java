package fpc.aoc.common.rules;

/**
 * A rule that checks that all char are hexa-digits and return its input
 */
public class AreAllHexDigits implements Rule<String, String> {

  public static AreAllHexDigits create() {
    return new AreAllHexDigits();
  }

  @Override
  public Validation<String> validate(String input) {
    if (input.chars().allMatch(this::isHexDigit)) {
      return Validation.valid(input);
    }
    return Validation.invalid();
  }

  private boolean isHexDigit(int character) {
    return (character >= '0' && character <= '9') || (character >= 'a' && character <= 'f');
  }
}
