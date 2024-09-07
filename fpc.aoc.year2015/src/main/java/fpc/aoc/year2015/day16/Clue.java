package fpc.aoc.year2015.day16;

import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class Clue {

  private final Map<String, IntPredicate> clues;

  public boolean matches(Sue sue) {
    return sue.characteristics()
      .entrySet()
      .stream()
      .allMatch(e -> match(e.getKey(), e.getValue()));
  }

  private boolean match(String name, int value) {
    return clues.get(name).test(value);
  }



  public static Clue create(TestFactory testFactory) {
    final var map = DATA.entrySet()
      .stream()
      .collect(Collectors.toMap(Map.Entry::getKey, e -> testFactory.create(e.getKey(), e.getValue())));

    return new Clue(map);
  }

  public static final Map<String, Integer> DATA = Map.of(
    "children", 3,
    "cats", 7,
    "samoyeds", 2,
    "pomeranians", 3,
    "akitas", 0,
    "vizslas", 0,
    "goldfish", 5,
    "trees", 3,
    "cars", 2,
    "perfumes", 1
  );


}
