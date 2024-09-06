package fpc.aoc.year2019.day20._private;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @author perococco
 **/
@Getter
@RequiredArgsConstructor
public enum PortalSearchParty {
  ABOVE(Position::down, p -> p.down(2), Position::down),
  ON_THE_LEFT(Position::right, p -> p.right(2), Position::right),
  ON_THE_RIGHT(Position::right, Position::left, p -> p),
  BELOW(Position::down, Position::up, p -> p),
  ;

  @NonNull
  private final UnaryOperator<Position> secondLetterPositionEstimator;
  @NonNull
  private final UnaryOperator<Position> exitPositionEstimator;

  @NonNull
  private final UnaryOperator<Position> entrancePositionEstimator;

  @NonNull
  public Optional<Portal> checkForPortal(@NonNull ArrayOfChar arrayOfChar, @NonNull Position searchedPosition) {
    return new Search(arrayOfChar, searchedPosition).execute();
  }

  @NonNull
  public static Stream<PortalSearchParty> valueStream() {
    return Holder.PARTIES.stream();
  }


  @RequiredArgsConstructor
  private class Search {

    @NonNull
    private final ArrayOfChar array;

    @NonNull
    private final Position searchedPosition;

    private Position exitPosition;

    private char firstLetter;
    private char secondLetter;

    @NonNull
    public Optional<Portal> execute() {
      if (isFirstLetterPositionValid() && isSecondLetterPositionValid() && isExitPositionValid()) {
        return Optional.of(createPortal());
      }
      return Optional.empty();
    }

    private boolean isFirstLetterPositionValid() {
      this.firstLetter = array.get(searchedPosition);
      return isALetter(firstLetter);
    }

    private boolean isSecondLetterPositionValid() {
      this.secondLetter = array.get(secondLetterPositionEstimator.apply(searchedPosition));
      return isALetter(secondLetter);
    }

    private boolean isExitPositionValid() {
      this.exitPosition = exitPositionEstimator.apply(searchedPosition);
      final char charAtExitPosition = array.get(exitPosition);
      return isAnEmptyTile(charAtExitPosition);
    }

    @NonNull
    private Portal createPortal() {
      final String name = "" + firstLetter + secondLetter;
      final Position entrance = entrancePositionEstimator.apply(searchedPosition);

      final boolean inside = exitPosition.x() != 2
                             && exitPosition.x() != array.width() - 3
                             && exitPosition.y() != 2
                             && exitPosition.y() != array.height() - 3;


      return new Portal(name, entrance, exitPosition, inside);
    }

    private boolean isALetter(char character) {
      return Tile.LETTER.isMyselfRepresentedByThisCharacter(character);
    }

    private boolean isAnEmptyTile(char character) {
      return Tile.EMPTY.isMyselfRepresentedByThisCharacter(character);
    }
  }

  private static class Holder {

    private static final List<PortalSearchParty> PARTIES = List.of(values());
  }
}
