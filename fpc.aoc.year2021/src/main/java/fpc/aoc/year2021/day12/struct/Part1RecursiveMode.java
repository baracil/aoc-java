package fpc.aoc.year2021.day12.struct;

import java.util.HashSet;
import java.util.Set;

public class Part1RecursiveMode implements RecursiveMode {

  private final Set<Node> visited = new HashSet<>();

  @Override
  public void onEntering(Node position) {
    if (position.start() || position.smallCave()) {
      visited.add(position);
    }
  }

  @Override
  public boolean canVisit(Node connection) {
    return !visited.contains(connection);
  }

  @Override
  public void onLeaving(Node position) {
    visited.remove(position);
  }
}
