package fpc.aoc.year2022.day8;

import fpc.aoc.common.*;

import java.util.stream.Stream;

public class Forest {

  private final ArrayOfChar treeHeights;
  private final GridHelper gridHelper;

  public Forest(ArrayOfChar treeHeights) {
    this.treeHeights = treeHeights;
    this.gridHelper = GridHelper.create(treeHeights.width(), treeHeights.height());
  }

  public long countNbVisibleTrees() {
    return gridHelper.allPositionOnGrid()
        .filter(this::isVisible)
        .count();
  }

  public long getBestScenicScore() {
    return gridHelper.allPositionOnGrid()
        .mapToLong(this::scenicScore)
        .max().orElseThrow(() -> new AOCException("To stupid to solve this!"));
  }

  private boolean isVisible(Position treePosition) {
    return Stream.of(Displacement.S, Displacement.N, Displacement.E, Displacement.W)
        .anyMatch(displacement -> isVisibleInOneDirection(treePosition, displacement));
  }

  private long scenicScore(Position treePosition) {
    return Stream.of(Displacement.S, Displacement.N, Displacement.E, Displacement.W)
        .mapToLong(displacement -> scenicScoreInOneDirection(treePosition, displacement))
        .reduce(1, (a, b) -> a * b);
  }


  public long scenicScoreInOneDirection(Position treePosition, Displacement displacement) {
    final var treeHeight = treeHeights.get(treePosition);
    return gridHelper.positionsInDirection(treePosition, displacement)
        .takeWhile(position -> treeHeights.get(position) < treeHeight && isNotOnBorder(position))
        .count() + 1;
  }

  private boolean isNotOnBorder(Position position) {
    return !gridHelper.isOnBorder(position);
  }

  private boolean isVisibleInOneDirection(Position treePosition, Displacement displacement) {
    final var treeHeight = treeHeights.get(treePosition);
    return gridHelper.positionsInDirection(treePosition, displacement)
        .map(treeHeights::get)
        .allMatch(h -> h < treeHeight);
  }

}
