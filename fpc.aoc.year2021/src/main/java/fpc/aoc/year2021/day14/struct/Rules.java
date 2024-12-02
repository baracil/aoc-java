package fpc.aoc.year2021.day14.struct;

import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class Rules {

  private final Map<Couple, Character> rules;


  public Optional<Character> getInsertion(Couple couple) {
    return Optional.ofNullable(rules.get(couple));
  }

  public static final Collector<InsertionRule, ?, Rules> COLLECTOR =
      Collectors.collectingAndThen(
          Collectors.toMap(InsertionRule::couple, InsertionRule::middle),
          Rules::new
      );
}
