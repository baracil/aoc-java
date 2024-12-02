package fpc.aoc.year2015.day18;

import fpc.aoc.common.CellState;
import fpc.aoc.common.GameOfLifeRule;
import fpc.aoc.common.Point2D;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Rule implements GameOfLifeRule<Point2D> {

  private final int limit;
  private final GameOfLifeRule<Object> basic = GameOfLifeRule.DEFAULT_RULE;

  @Override
  public CellState computeNewState(CellState previousState, int nbNeighbour, Point2D position) {
    if (position.x() < 0 || position.x() >= limit || position.y() < 0 || position.y() >= limit) {
      return CellState.DEAD;
    }
    return basic.computeNewState(previousState, nbNeighbour, position);
  }
}
