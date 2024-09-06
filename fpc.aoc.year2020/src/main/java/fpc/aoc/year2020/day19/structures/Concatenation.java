package fpc.aoc.year2020.day19.structures;

import fpc.aoc.common.AOCException;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
@ToString
public class Concatenation implements Rule {

  private final @NonNull List<Integer> ruleIds;

  @Override
  public Stream<IndexedString> matches(@NonNull IndexedString string, @NonNull RuleProvider ruleProvider) {
    return ruleIds.stream()
        .map(ruleProvider)
        .reduce(Stream.of(string),
            (stream, rule) -> stream.flatMap(m -> rule.matches(m, ruleProvider)),
            Stream::concat);
  }

  public static @NonNull Concatenation concatenation(int... ruleIds) {
    return new Concatenation(IntStream.of(ruleIds).boxed().toList());
  }

  static @NonNull Concatenation parse(@NonNull String line) {
    try {
      final var ruleIds = Arrays.stream(line.trim().split(" "))
          .map(Integer::parseInt)
          .toList();
      return new Concatenation(ruleIds);
    } catch (Exception e) {
      throw new AOCException("This line is not a concatenation rule '" + line + "'", e);
    }
  }

}
