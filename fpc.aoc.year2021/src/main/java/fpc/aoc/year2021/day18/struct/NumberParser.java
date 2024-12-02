package fpc.aoc.year2021.day18.struct;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberParser {

  public static Node parse(String input) {
    return new NumberParser(input).parse();
  }

  private final String input;

  private Node parse() {
    if (!input.startsWith("[")) {
      return new Node.Literal(Integer.parseInt(input));
    } else {
      int count = 0;
      int commaPos = 0;
      int pos = -1;
      do {
        pos++;
        var c = input.charAt(pos);
        switch (c) {
          case '[' -> ++count;
          case ']' -> --count;
          case ',' -> {
            if (count == 1) {
              commaPos = pos;
            }
          }
        }
      }
      while (count != 0);
      final var left = NumberParser.parse(input.substring(1, commaPos));
      final var right = NumberParser.parse(input.substring(commaPos + 1, pos));
      return new Node.Pair(left, right);
    }
  }

}
