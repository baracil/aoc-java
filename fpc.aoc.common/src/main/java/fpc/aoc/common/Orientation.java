package fpc.aoc.common;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Cardinal orientation
 */
@RequiredArgsConstructor
@Getter
public enum Orientation implements Translation {
  N(0, -1),
  E(1, 0),
  S(0, 1),
  W(-1, 0),
  ;


  private final int dx;
  private final int dy;


  public Orientation opposite() {
    return switch (this) {
      case N -> S;
      case E -> W;
      case S -> N;
      case W -> E;
    };
  }

  public char toChar() {
    return switch (this) {
      case N -> '^';
      case E -> '>';
      case S -> 'V';
      case W -> '<';
    };
  }

  @NonNull
  public Command commandToSwitchTo(Orientation target) {
    if (rotateEast() == target) {
      return Command.RIGHT;
    }
    else if (rotateWest() == target) {
      return Command.LEFT;
    }
    throw new AOCException("Cannot find command to switch from "+this+" to "+target);
  }


  @NonNull
  public Orientation rotateWest() {
    return turn(-90);
  }

  @NonNull
  public Orientation rotateEast() {
    return turn(90);
  }

  @NonNull
  public Position moveForward(Position position) {
    return position.translate(dx, dy);
  }


  public Orientation turn(int angle) {
    final int a = Tools.mod(angle, 360);
    assert a == 0 || a == 90 || a == 180 || a == 270;
    return Holder.ROTATION.get(this)[a / 90];
  }

  public static List<Orientation> allValues() {
    return Holder.VALUES;
  }

  private static final class Holder {

    private static final List<Orientation> VALUES = List.of(values());
    private static final Map<Orientation, Orientation[]> ROTATION;

    static {
      ROTATION = Map.of(
          N, new Orientation[]{N, E, S, W},
          E, new Orientation[]{E, S, W, N},
          S, new Orientation[]{S, W, N, E},
          W, new Orientation[]{W, N, E, S}
      );
    }

  }
}
