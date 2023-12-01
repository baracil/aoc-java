package fpc.aoc.day1;

import java.util.function.ToIntFunction;

public class LineConverterPart1 implements ToIntFunction<String> {

  @Override
  public int applyAsInt(String value) {
    int first = -1;
    int last = -1;
    for (int i = 0, j = value.length() - 1; i < value.length(); i++, j--) {
      final var c1 = value.charAt(i);
      final var c2 = value.charAt(j);
      if (first < 0 && c1>='0' && c1<='9') {
        first = c1-'0';
        if (last>=0) {
          return first*10+last;
        }
      }

      if (last < 0 && c2>='0' && c2<='9') {
        last = c2-'0';
        if (first>0) {
          return first*10+last;
        }
      }
    }
    throw new IllegalArgumentException(value);
  }
}
