package fpc.aoc.year2021.day12.struct;

public interface RecursiveMode {
  void onEntering(Node position);

  boolean canVisit(Node connection);

  void onLeaving(Node position);
}
