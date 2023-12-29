package fpc.aoc.year2023.day04;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.function.Predicate.not;

public class CardParser implements Function<String, Card> {

  @Override
  public Card apply(String s) {
    return parse(s);
  }

  public Card parse(String line) {
    final var tokens = line.split(":", 2);
    final var id = tokens[0];
    final var numbers = tokens[1].split("\\|");

    final boolean[] buffer = new boolean[100];
    toStreamOfInt(numbers[0]).forEach(i -> buffer[i] = true);
    final var count = (int) toStreamOfInt(numbers[1]).filter(i -> buffer[i]).count();

    return new Card(id, count);
  }

  private IntStream toStreamOfInt(String numbers) {
    return Arrays.stream(numbers.split(" "))
        .map(String::trim)
        .filter(not(String::isEmpty))
        .mapToInt(Integer::parseInt);
  }

}
