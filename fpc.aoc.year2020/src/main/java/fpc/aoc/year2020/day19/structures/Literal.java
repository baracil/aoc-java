package fpc.aoc.year2020.day19.structures;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.stream.Stream;

@RequiredArgsConstructor
@ToString
public class Literal implements Rule {

  @Getter
  private final char value;

  @Override
  public Stream<IndexedString> matches(@NonNull IndexedString string, @NonNull RuleProvider ruleProvider) {
    if (!string.isEmpty() && string.charAt(0) == value) {
      return Stream.of(string.addToOffset(1));
    }
    return Stream.empty();
  }

  static @NonNull Literal parse(@NonNull String line) {
    return new Literal(line.trim().charAt(1));
  }

}
