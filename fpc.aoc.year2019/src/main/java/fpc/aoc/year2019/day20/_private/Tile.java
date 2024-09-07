package fpc.aoc.year2019.day20._private;

import fpc.aoc.common.AOCException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Bastien Aracil
 **/
@RequiredArgsConstructor
public enum Tile {
  WALL('#'),
  EMPTY('.'),
  SPACE(' '),
  LETTER(c -> c >= 'A' && c <= 'Z'),
  ;

  private final Predicate<Character> thisTileTypeTester;

  public static Tile getTile(char character) {
    for (Tile value : Holder.VALUES) {
      if (value.thisTileTypeTester.test(character)) {
        return value;
      }
    }
    throw new AOCException("Could not transform character '" + character + "' to a tile type");
  }

  public boolean isMyselfRepresentedByThisCharacter(char character) {
    return thisTileTypeTester.test(character);
  }

  Tile(char character) {
    this.thisTileTypeTester = c -> c == character;
  }

  private static class Holder {

    private static final List<Tile> VALUES = List.of(values());
  }


}
