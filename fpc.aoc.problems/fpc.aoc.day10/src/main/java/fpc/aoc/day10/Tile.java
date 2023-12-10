package fpc.aoc.day10;

import fpc.aoc.common.Orientation;
import lombok.Getter;

@Getter
public enum Tile {
  PIPE_H('-', "━", Orientation.W, Orientation.E),
  PIPE_V('|', "┃", Orientation.N, Orientation.S),
  CORNER_L('L', "┗", Orientation.N, Orientation.E),
  CORNER_J('J', "┛", Orientation.N, Orientation.W),
  CORNER_7('7', "┓", Orientation.S, Orientation.W),
  CORNER_F('F', "┏", Orientation.E, Orientation.S),
  FLOOR('.', "◌"),
  START('S', "*"),
  ;

  private final char code;
  private final String displayed;
  private final Orientation[] displacements;

  Tile(char code, String displayed, Orientation... displacements) {
    this.code = code;
    this.displayed = displayed;
    this.displacements = displacements;
  }

  public static Tile parse(int tile) {
    return switch (tile) {
      case '-' -> PIPE_H;
      case '|' -> PIPE_V;
      case 'L' -> CORNER_L;
      case 'J' -> CORNER_J;
      case '7' -> CORNER_7;
      case 'F' -> CORNER_F;
      case '.' -> FLOOR;
      case 'S' -> START;
      default -> throw new IllegalArgumentException("Unknown char " + tile);
    };
  }

  public static Tile estimate(Tile north, Tile east, Tile south, Tile west) {
    final var t = north.hasOrientation(Orientation.S) ? 1000 : 0;
    final var r = east.hasOrientation(Orientation.W) ? 100 : 0;
    final var d = south.hasOrientation(Orientation.N) ? 10 : 0;
    final var l = west.hasOrientation(Orientation.E) ? 1 : 0;
    return switch (t + r + d + l) {
      case 1100 -> CORNER_L;
      case 1010 -> PIPE_V;
      case 1001 -> CORNER_J;
      case 110 -> CORNER_F;
      case 101 -> PIPE_H;
      case 11 -> CORNER_7;
      default -> throw new IllegalArgumentException("Could not estimate start");
    };

  }

  public boolean hasOrientation(Orientation orientation) {
    for (Orientation o : displacements) {
      if (o == orientation) {
        return true;
      }
    }
    return false;
  }

  public Orientation getAny() {
    if (displacements.length == 0) {
      return null;
    }
    return displacements[0];
  }

  public Orientation getOther(Orientation displacement) {
    for (Orientation o : displacements) {
      if (o != displacement) {
        return o;
      }
    }
    return null;
  }


  public static Tile estimateStart(Tile northTile, Tile eastTile, Tile southTile, Tile westTile) {
    final var t = northTile.hasOrientation(Orientation.S) ? 1000 : 0;
    final var r = eastTile.hasOrientation(Orientation.W) ? 100 : 0;
    final var d = southTile.hasOrientation(Orientation.N) ? 10 : 0;
    final var l = westTile.hasOrientation(Orientation.E) ? 1 : 0;
    return switch (t + r + d + l) {
      case 1100 -> CORNER_L;
      case 1010 -> PIPE_V;
      case 1001 -> CORNER_J;
      case 110 -> CORNER_F;
      case 101 -> PIPE_H;
      case 11 -> CORNER_7;
      default -> throw new IllegalArgumentException("Could not estimate start");
    };
  }

}
