package fpc.aoc.day1;

import java.util.function.ToIntFunction;
import java.util.regex.Pattern;

public class LineConverterPart2 implements ToIntFunction<String> {

  private static final Pattern PATTERN = Pattern.compile("(one|two|three|four|five|six|seven|eight|nine|[1-9]).*");

  @Override
  public int applyAsInt(String value) {
    final int first = first(value);
    final int last = last(value);
    return first*10+last;
  }

  private int first(String value) {
    for (int i = 0; i < value.length(); i++) {
      final var m = PATTERN.matcher(value.substring(i));
      if (m.matches()) {
        final var group = m.group(1);
        return toInt(group);
      }
    }
    return 0;
  }

  private int last(String value) {
    for (int i = 0; i < value.length(); i++) {
      final var m = PATTERN.matcher(value.substring(value.length()-i-1));
      if (m.matches()) {
        final var group = m.group(1);
        return toInt(group);
      }
    }
    return 0;
  }

  private int toInt(String value) {
    return switch (value) {
      case "one","1" -> 1;
      case "two","2" -> 2;
      case "three","3" -> 3;
      case "four","4" -> 4;
      case "five","5" -> 5;
      case "six","6" -> 6;
      case "seven","7" -> 7;
      case "eight","8" -> 8;
      case "nine","9" -> 9;
      default -> 0;
    };
  }
}
