package fpc.aoc.year2022.day23;

import fpc.aoc.common.Pair;
import fpc.aoc.common.Position;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
public class Elves {

  private static final Direction[] DIRECTIONS = {Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};

  private final int directionOffset;
  private final Set<Position> positions;
  @Getter
  private final boolean allIsolated;

  public Elves(Set<Position> positions) {
    this.directionOffset = 0;
    this.positions = positions;
    this.allIsolated = false;
  }

  public Elves performOneRound() {
    final var propositions = getPropositions();

    final Set<Position> positions = new HashSet<>();
    for (Map.Entry<Position, List<Position>> entry : propositions.first().entrySet()) {
      final var newPosition = entry.getKey();
      final var oldPositions = entry.getValue();
      if (oldPositions.size() == 1) {
        positions.add(newPosition);
      } else {
        positions.addAll(oldPositions);
      }
    }

    return new Elves((directionOffset + 1) % DIRECTIONS.length, positions, propositions.second() == this.positions.size());
  }

  private Pair<Map<Position, List<Position>>, Integer> getPropositions() {
    final Map<Position, List<Position>> propositions = new HashMap<>();
    int nbIsolated = 0;
    for (Position position : positions) {
      final var proposition = getProposition(position);

      final Position newPosition;

      if (proposition == null) {
        nbIsolated++;
        newPosition = position;
      } else {
        newPosition = proposition;
      }
      propositions.computeIfAbsent(newPosition, p -> new ArrayList<>()).add(position);
    }
    return Pair.of(propositions, nbIsolated);
  }

  private Position getProposition(Position position) {
    final var occupancy = Occupancy.compute(position, positions);
    if (occupancy.isIsolate()) {
      return null;
    }

    for (int i = 0; i < DIRECTIONS.length; i++) {
      final var direction = DIRECTIONS[(directionOffset + i) % DIRECTIONS.length];
      if (occupancy.isFree(direction)) {
        return position.displaced(direction.displacement());
      }
    }

    return position;
  }

  public void dump() {
    final var statX = positions.stream().mapToInt(Position::x).summaryStatistics();
    final var statY = positions.stream().mapToInt(Position::y).summaryStatistics();
    System.out.println();
    for (int y = statY.getMin(); y <= statY.getMax(); y++) {
      for (int x = statX.getMin(); x <= statX.getMax(); x++) {
        final var pos = new Position(x, y);
        if (positions.contains(pos)) {
          System.out.print('#');
        } else {
          System.out.print('.');
        }
      }
      System.out.println();
    }
  }

  public int nbEmptyGrounds() {
    final var statX = positions.stream().mapToInt(Position::x).summaryStatistics();
    final var statY = positions.stream().mapToInt(Position::y).summaryStatistics();
    final var height = statY.getMax() - statY.getMin() + 1;
    final var width = statX.getMax() - statX.getMin() + 1;
    return height * width - positions.size();
  }

}
