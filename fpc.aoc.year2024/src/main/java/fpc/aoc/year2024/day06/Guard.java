package fpc.aoc.year2024.day06;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Orientation;
import fpc.aoc.common.Position;
import jakarta.annotation.Nullable;


public record Guard(Position position, Orientation orientation) {


  public @Nullable Guard move(ArrayOfChar map, Position obstacle) {
    var current = this.orientation;
    do {
      var newPosition = this.position.displaced(current);
      char c = map.get(newPosition);
      if (c == Day6Solver.BORDER) {
        return null;
      }
      if (c != '#' && !newPosition.equals(obstacle)) {
        return new Guard(newPosition, current);
      }
      current = current.rotateEast();
    } while (current != orientation);
    return null;
  }

  public @Nullable Guard move(ArrayOfChar map) {
    return move(map, null);
  }

}
