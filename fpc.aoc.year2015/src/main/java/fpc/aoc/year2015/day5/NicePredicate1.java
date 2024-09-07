package fpc.aoc.year2015.day5;

import java.util.function.Predicate;

public class NicePredicate1 implements Predicate<String> {

  @Override
  public boolean test(String s) {
    char prev = s.charAt(0);
    boolean hasTwice = false;
    int nbVowels = isVowel(prev);
    for (int i = 1; i < s.length(); i++) {
      final var c = s.charAt(i);
      if (prev == 'a' && c == 'b' || prev == 'c' && c == 'd' || prev == 'p' && c == 'q' || prev == 'x' && c == 'y') {
        return false;
      }
      hasTwice |= c == prev;
      nbVowels += isVowel(c);
      prev = c;
    }
    return nbVowels >= 3 && hasTwice;
  }

  private int isVowel(char prev) {
    return (prev == 'a' || prev == 'e' || prev == 'i' || prev == 'o' || prev == 'u') ? 1 : 0;
  }
}
