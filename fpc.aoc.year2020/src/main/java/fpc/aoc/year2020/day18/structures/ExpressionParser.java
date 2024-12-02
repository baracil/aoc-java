package fpc.aoc.year2020.day18.structures;

import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class ExpressionParser {


  private final String expressionAsString;

  private int index;

  public Optional<Token> getNextToken() {
    if (index >= expressionAsString.length()) {
      return Optional.empty();
    }
    final var chr = expressionAsString.charAt(index);
    if (chr == '(') {
      index++;
      return Optional.of(Token.openParenthesis());
    } else if (chr == ')') {
      index++;
      return Optional.of(Token.closingParenthesis());
    } else if (chr == '+') {
      index++;
      return Optional.of(Token.addition());
    } else if (chr == '*') {
      index++;
      return Optional.of(Token.multiplication());
    } else if (chr == ' ') {
      index++;
      return getNextToken();
    } else {
      final var endOfNumber = IntStream.iterate(index, i -> i + 1)
          .filter(this::isNotADigit)
          .findFirst()
          .orElse(expressionAsString.length());

      final var token = Token.number(Long.parseLong(expressionAsString.substring(index, endOfNumber)));
      index = endOfNumber;
      return Optional.of(token);

    }
  }

  private boolean isNotADigit(int idx) {
    if (idx >= expressionAsString.length()) {
      return true;
    }
    final var chr = expressionAsString.charAt(idx);
    return chr < '0' || chr > '9';
  }
}
