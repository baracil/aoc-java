package fpc.aoc.year2020.day19.structures;

import lombok.NonNull;

import java.util.stream.Stream;

public interface Rule {

  /**
   * @param string       the string the match
   * @param ruleProvider a function that returns a rule from its id
   * @return a stream of indexed string obtained after matching the provided string
   * to this rule (this is a stream because the string might matches in several ways)
   */
  Stream<IndexedString> matches(@NonNull IndexedString string, @NonNull RuleProvider ruleProvider);


  static @NonNull Rule parse(@NonNull String line) {
    final int indexOfPipe = line.indexOf('|');
    final int indexOfQuote = line.indexOf('"');
    if (indexOfPipe >= 0) {
      return Or.parse(line);
    }
    if (indexOfQuote >= 0) {
      return Literal.parse(line);
    }
    return Concatenation.parse(line);
  }

}
