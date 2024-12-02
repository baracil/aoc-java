package fpc.aoc.year2020.day19.structures;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
@ToString
public class Literal implements Rule {

  private final char value;

  @Override
  public Stream<IndexedString> matches(IndexedString string, RuleProvider ruleProvider) {
    if (!string.isEmpty() && string.charAt(0) == value) {
      return Stream.of(string.addToOffset(1));
    }
    return Stream.empty();
  }

  static Literal parse(String line) {
    return new Literal(line.trim().charAt(1));
  }

}
