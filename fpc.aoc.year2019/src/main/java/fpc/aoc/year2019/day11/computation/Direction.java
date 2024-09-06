package fpc.aoc.year2019.day11.computation;

import fpc.aoc.common.Position;
import lombok.NonNull;

public enum Direction {
  UP() {
    @Override
    public Direction turnLeft() {
      return LEFT;
    }

    @Override
    public Direction turnRight() {
      return RIGHT;
    }

    @Override
    public Position moveForward(@NonNull Position position) {
      return position.translateY(-1);
    }
  },
  DOWN {
    @Override
    public Direction turnLeft() {
      return RIGHT;
    }

    @Override
    public Direction turnRight() {
      return LEFT;
    }

    @Override
    public Position moveForward(@NonNull Position position) {
      return position.translateY(1);
    }
  },
  LEFT {
    @Override
    public Direction turnLeft() {
      return DOWN;
    }

    @Override
    public Direction turnRight() {
      return UP;
    }

    @Override
    public Position moveForward(@NonNull Position position) {
      return position.translateX(-1);
    }
  },
  RIGHT {
    @Override
    public Direction turnLeft() {
      return UP;
    }

    @Override
    public Direction turnRight() {
      return DOWN;
    }

    @Override
    public Position moveForward(@NonNull Position position) {
      return position.translateX(1);
    }
  },
  ;

  public abstract Direction turnLeft();

  public abstract Direction turnRight();

  public abstract Position moveForward(@NonNull Position position);
}
