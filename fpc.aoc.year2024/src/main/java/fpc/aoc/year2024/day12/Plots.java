package fpc.aoc.year2024.day12;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Plots {

  private final List<Plot> plots;

  public int getPricePart1() {
    return plots.stream().mapToInt(p -> p.area() * p.perimeter()).sum();
  }

  public int getPricePart2() {
    return plots.stream().mapToInt(p -> p.area() * p.nbSides()).sum();
  }

}
