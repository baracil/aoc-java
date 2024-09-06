package fpc.aoc.year2020.day19.structures;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
@ToString
public class Or implements Rule {

  private final @NonNull Concatenation first;

  private final @NonNull Concatenation second;

  @Override
  public Stream<IndexedString> matches(@NonNull IndexedString string, @NonNull RuleProvider ruleProvider) {
    return Stream.of(first, second)
        .flatMap(r -> r.matches(string, ruleProvider));
  }

  public static @NonNull Or or(@NonNull Concatenation first, @NonNull Concatenation second) {
    return new Or(first, second);
  }

  static @NonNull Or parse(@NonNull String line) {
    final var tokens = line.trim().split("\\|");
    return new Or(Concatenation.parse(tokens[0]), Concatenation.parse(tokens[1]));
  }

}
