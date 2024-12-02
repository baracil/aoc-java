package fpc.aoc.year2020.day19.structures;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
@ToString
public class Or implements Rule {

  private final Concatenation first;

  private final Concatenation second;

  @Override
  public Stream<IndexedString> matches(IndexedString string, RuleProvider ruleProvider) {
    return Stream.of(first, second)
        .flatMap(r -> r.matches(string, ruleProvider));
  }

  public static Or or(Concatenation first, Concatenation second) {
    return new Or(first, second);
  }

  static Or parse(String line) {
    final var tokens = line.trim().split("\\|");
    return new Or(Concatenation.parse(tokens[0]), Concatenation.parse(tokens[1]));
  }

}
