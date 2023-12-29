package fpc.aoc.year2022.day22;

import fpc.aoc.common.ArrayOfChar;

public interface NavigationFactory {

  Navigation create(ArrayOfChar map);


  static NavigationFactory part1() {
    return map -> new Part1NavigationFactory(map).create();
  }

  static NavigationFactory part2() {
    return map -> new Part2NavigationFactory(map).create();
  }
}
