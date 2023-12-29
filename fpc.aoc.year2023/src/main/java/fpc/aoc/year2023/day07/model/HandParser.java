package fpc.aoc.year2023.day07.model;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class HandParser implements Function<String,Hand> {

  public static HandParser forPart1() {
    return new HandParser(9);
  }

  public static HandParser forPart2() {
    return new HandParser(-1);
  }


  private final TypeEvaluator typeEvaluator = new TypeEvaluator();
  private final int jackValue;

  @Override
  public Hand apply(String s) {
    return parse(s);
  }

  public Hand parse(String line) {
    final var tokens = line.trim().split(" ");
    final var cards = tokens[0].chars().map(this::mapCardValue).toArray();
    final var bid = Integer.parseInt(tokens[1]);
    return new Hand(typeEvaluator.evaluate(cards), tokens[0], cards, bid);
  }

  private int mapCardValue(int card) {
    return switch (card) {
      case '2', '3', '4', '5', '6', '7', '8', '9' -> card - '2';
      case 'T' -> 8;
      case 'J' -> jackValue;
      case 'Q' -> 10;
      case 'K' -> 11;
      case 'A' -> 12;
      default -> throw new IllegalArgumentException("Invalid card '" + card + "'");
    };
  }
}
