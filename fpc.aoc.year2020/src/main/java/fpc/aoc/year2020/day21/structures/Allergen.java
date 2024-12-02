package fpc.aoc.year2020.day21.structures;

import lombok.Value;

@Value
public class Allergen implements Comparable<Allergen> {

  String name;

  @Override
  public int compareTo(Allergen o) {
    return name.compareTo(o.name);
  }
}
