package fpc.aoc.year2023.day01;

import lombok.RequiredArgsConstructor;

import java.util.function.IntUnaryOperator;
import java.util.function.ToIntFunction;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class LineConverter implements ToIntFunction<String> {

  public static LineConverter forPart1() {
    return new LineConverter(Pattern.compile("([1-9]).*"));
  }

  public static LineConverter forPart2() {
    return new LineConverter(Pattern.compile("(one|two|three|four|five|six|seven|eight|nine|[1-9]).*"));
  }


  private final Pattern pattern;

  @Override
  public int applyAsInt(String value) {
    final int first = find(value, i -> i);
    final int last = find(value, i -> value.length() - i - 1);
    return first * 10 + last;
  }

  private int find(String value, IntUnaryOperator indexGetter) {
    for (int i = 0; i < value.length(); i++) {
      final var m = pattern.matcher(value.substring(indexGetter.applyAsInt(i)));
      if (m.matches()) {
        final var group = m.group(1);
        return toInt(group);
      }
    }
    return 0;
  }

  private int toInt(String value) {
    return switch (value) {
      case "one", "1" -> 1;
      case "two", "2" -> 2;
      case "three", "3" -> 3;
      case "four", "4" -> 4;
      case "five", "5" -> 5;
      case "six", "6" -> 6;
      case "seven", "7" -> 7;
      case "eight", "8" -> 8;
      case "nine", "9" -> 9;
      default -> 0;
    };
  }
}
