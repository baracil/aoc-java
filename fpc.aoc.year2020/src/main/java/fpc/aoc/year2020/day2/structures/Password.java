package fpc.aoc.year2020.day2.structures;

import lombok.NonNull;

public class Password {

  private final int[] charOccurrences = new int['z' - 'a' + 1];

  private final @NonNull String literal;

  public Password(@NonNull String value) {
    this.literal = value;
    value.chars().map(c -> c - 'a').forEach(i -> charOccurrences[i]++);
  }

  public int getCharOccurrence(char character) {
    int pos = character - 'a';
    if (pos < 0 || pos >= charOccurrences.length) {
      System.out.println("OOPS");
      return 0;
    }
    return charOccurrences[pos];
  }

  public char getCharAt(int position) {
    return literal.charAt(position);
  }
}
