package fpc.aoc.year2020.day2.structures;

import lombok.Value;

@Value
public class OldRule implements Rule {
  int minOccurrence;
  int maxOccurrence;
  char character;

  public static OldRule parse(String ruleAsString) {
    final String[] token = ruleAsString.split("[- ]", 3);
    return new OldRule(
        Integer.parseInt(token[0]),
        Integer.parseInt(token[1]),
        token[2].charAt(0)
    );
  }

  @Override
  public boolean isPasswordValid(Password password) {
    final var occurrence = password.getCharOccurrence(character);
    return occurrence >= minOccurrence && occurrence <= maxOccurrence;
  }
}
