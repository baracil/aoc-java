package fpc.aoc.year2015.day5;

import java.util.function.Predicate;

public class NicePredicate2 implements Predicate<String> {

  @Override
  public boolean test(String s) {
    return hasPair(s) && hasCouple(s);
  }

  private boolean hasPair(String value) {
    for (int i = 0; i < value.length() - 3; i++) {
      final var s= value.substring(i,i+2);
      if (value.indexOf(s, i + 2)>=0) {
        return true;
      }
    }
    return false;
  }

  private boolean hasCouple(String value) {
    for (int i = 0; i < value.length() - 2; i++) {
      if (value.charAt(i) == value.charAt(i+2)) {
        return true;
      }
    }
    return false;
  }
}
