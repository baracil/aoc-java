package fpc.aoc.year2020.day19.structures;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class Tester implements Predicate<String> {

  private final @NonNull Map<Integer, Rule> rules;

  @Override
  public boolean test(String message) {
    return rules.get(0)
        .matches(IndexedString.initial(message), rules::get)
        .anyMatch(IndexedString::isEmpty);
  }


}