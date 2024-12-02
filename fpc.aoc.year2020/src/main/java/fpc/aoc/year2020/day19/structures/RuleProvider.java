package fpc.aoc.year2020.day19.structures;

import lombok.NonNull;

import java.util.function.Function;

public interface RuleProvider extends Function<Integer, Rule> {

  @NonNull
  Rule getRule(int id);

  @Override
  default Rule apply(Integer integer) {
    return getRule(integer);
  }
}
