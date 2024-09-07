package fpc.aoc.year2015.day10;

public class LookAndSay {

  public static String oneStep(String s) {
    int i = 0;
    int j;
    StringBuilder result = new StringBuilder();
    while(i<s.length()) {
      final var c = s.charAt(i);
      j = i+1;
      while(j<s.length() && s.charAt(j) == c) {
        j++;
      }
      result.append(j-i).append(c);
      i = j;
    }

    return result.toString();
  }
}
