package fpc.aoc.year2020.day18.structures;

import fpc.aoc.common.AOCException;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Token {

  @NonNull TokenType type;
  Long value;

  public static Token openParenthesis() {
    return new Token(TokenType.OPEN_PARENTHESIS, null);
  }

  public static Token closingParenthesis() {
    return new Token(TokenType.CLOSING_PARENTHESIS, null);
  }

  public static Token multiplication() {
    return new Token(TokenType.MULTIPLY, null);
  }

  public static Token addition() {
    return new Token(TokenType.ADD, null);
  }

  public static Token number(long value) {
    return new Token(TokenType.NUMBER, value);
  }

  public boolean isOperation() {
    return type == TokenType.ADD || type == TokenType.MULTIPLY;
  }

  public Token operate(Token t1, Token t2) {
    return switch (type) {
      case MULTIPLY -> new Token(TokenType.NUMBER, t1.value * t2.value);
      case ADD -> new Token(TokenType.NUMBER, t1.value + t2.value);
      default -> throw new AOCException("type '" + type + "' is not an operation");
    };
  }
}
