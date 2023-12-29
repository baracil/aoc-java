package fpc.aoc.year2020.day12.structures;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Tools;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Part2Executor implements Executor {

  private final @NonNull Ferry ferry;
  private final @NonNull Waypoint waypoint;

  @Override
  public void executeEast(int quantity) {
    waypoint.x(waypoint.x() + quantity);
  }

  @Override
  public void executeWest(int quantity) {
    executeEast(-quantity);
  }

  @Override
  public void executeNorth(int quantity) {
    waypoint.y(waypoint.y() + quantity);
  }

  @Override
  public void executeSouth(int quantity) {
    executeNorth(-quantity);
  }

  @Override
  public void executeLeft(int quantity) {
    executeRight(-quantity);
  }

  @Override
  public void executeRight(int quantity) {
    final int angle = Tools.mod(quantity, 360);
    final int x = ferry.x();
    final int y = ferry.y();
    final int dx = waypoint.x() - ferry.x();
    final int dy = waypoint.y() - ferry.y();
    switch (angle) {
      case 90 -> {
        waypoint.x(x + dy);
        waypoint.y(y - dx);
      }
      case 180 -> {
        waypoint.x(x - dx);
        waypoint.y(y - dy);
      }
      case 270 -> {
        waypoint.x(x - dy);
        waypoint.y(y + dx);
      }
      case 0 -> {

      }
      default -> throw new AOCException("Cannot handle angle '" + angle + "'");
    }

  }

  @Override
  public void executeForward(int quantity) {
    final int dx = (waypoint.x() - ferry.x()) * quantity;
    final int dy = (waypoint.y() - ferry.y()) * quantity;
    ferry.moveBy(dx, dy);
    waypoint.moveBy(dx, dy);
  }

  @Override
  public void execute(@NonNull Movement movement) {
    movement.operation().execute(this, movement.quantity());
  }

  @Override
  public String toString() {
    return "Part2Executor{" +
        "ferry=" + ferry +
        ", waypoint=" + waypoint +
        '}';
  }
}
