package fpc.aoc.year2022.day17;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Game {

  private final @NonNull Jet jet;
  private final Chamber chamber = new Chamber();
  private final ShapeGenerator generator = new ShapeGenerator();
  private int turnIndex = 0;
  private int jetIndex = 0;
  private int shapeIndex = 0;


  public long getTowerHeight() {
    return chamber.highestRock();
  }

  /**
   * @return the state before making the shape fall
   */
  public @NonNull TurnInfo fallOnePiece() {
    final var shapeType = generator.getShape(shapeIndex);
    final var turnInfo = new TurnInfo(shapeType, chamber.peekSnapshot(shapeType, jetIndex), turnIndex, chamber.highestRock());

    shapeIndex++;
    turnIndex++;

    final var shape = new Shape(shapeType, chamber.getStartingPosition());
    do {
      jet.getJetDirection(jetIndex).move(shape, chamber);
      jetIndex = jet.increaseIndex(jetIndex);
      final var settled = shape.moveDown(chamber);
      if (settled) {
        chamber.putShape(shape);
        break;
      }
    } while (true);

    return turnInfo;
  }

}
