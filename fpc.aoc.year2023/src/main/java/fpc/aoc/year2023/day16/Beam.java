package fpc.aoc.year2023.day16;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Orientation;
import fpc.aoc.common.Position;

import java.util.List;

public record Beam(Position position, Orientation orientation) {

  public Beam(int x, int y, Orientation orientation) {
    this(Position.of(x, y), orientation);
  }

  public List<Beam> move(char c) {
    return switch (c) {
      case '.' -> simpleMove();
      case '-' -> switch (orientation) {
        case E, W -> simpleMove();
        case S, N -> split();
      };
      case '|' -> switch (orientation) {
        case E, W -> split();
        case S, N -> simpleMove();
      };
      case '\\' -> handleAntiSlash();
      case '/' -> handleSlash();
      default -> throw new AOCException("Unknown char '" + c + "'");
    };
  }

  private List<Beam> simpleMove() {
    return List.of(new Beam(position.displaced(orientation), orientation));
  }

  private List<Beam> split() {
    return switch (orientation) {
      case E, W -> List.of(move(Orientation.S), move(Orientation.N));
      case S, N -> List.of(move(Orientation.E), move(Orientation.W));
    };
  }

  private List<Beam> handleSlash() {
    return List.of(move(slash()));
  }

  private List<Beam> handleAntiSlash() {
    return List.of(move(antiSlash()));
  }


  private Orientation antiSlash() {
    return switch (orientation) {
      case W -> Orientation.N;
      case E -> Orientation.S;
      case N -> Orientation.W;
      case S -> Orientation.E;
    };
  }

  private Orientation slash() {
    return switch (orientation) {
      case W -> Orientation.S;
      case E -> Orientation.N;
      case S -> Orientation.W;
      case N -> Orientation.E;
    };
  }

  private Beam move(Orientation o) {
    return new Beam(position.displaced(o), o);
  }

  public boolean isInside(int width, int height) {
    final var x = position.x();
    final var y = position.y();
    return x >= 0 && x < width && y >= 0 && y < height;
  }
}
