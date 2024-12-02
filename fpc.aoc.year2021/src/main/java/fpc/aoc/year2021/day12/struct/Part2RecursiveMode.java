package fpc.aoc.year2021.day12.struct;

import java.util.HashSet;
import java.util.Set;

public class Part2RecursiveMode implements RecursiveMode {

  private final Set<Node> visited = new HashSet<>();
  private Node doubled = null;

  @Override
  public void onEntering(Node position) {
    if (position.start()) {
      visited.add(position);
    }
    if (position.smallCave()) {
      if (visited.contains(position)) {
        doubled = position;
      } else {
        visited.add(position);
      }
    }
  }

  @Override
  public boolean canVisit(Node connection) {
    if (connection.start() || connection.end()) {
      return false;
    }
    if (connection.smallCave()) {
      return !visited.contains(connection) || doubled == null;
    }
    return true;
  }

  @Override
  public void onLeaving(Node position) {
    if (position.start()) {
      visited.remove(position);
    }
    if (position.smallCave()) {
      if (position.equals(doubled)) {
        doubled = null;
      } else {
        visited.remove(position);
      }
    }
  }
}
