package fpc.aoc.year2020.day12.structures;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Part1Executor implements Executor {

  private final Ferry ferry;

  @Override
  public void executeEast(int quantity) {
    ferry.x(ferry.x() + quantity);
  }

  @Override
  public void executeWest(int quantity) {
    ferry.x(ferry.x() - quantity);
  }

  @Override
  public void executeNorth(int quantity) {
    ferry.y(ferry.y() + quantity);
  }

  @Override
  public void executeSouth(int quantity) {
    ferry.y(ferry.y() - quantity);
  }

  @Override
  public void executeLeft(int quantity) {
    executeRight(-quantity);
  }

  @Override
  public void executeRight(int quantity) {
    ferry.orientation(ferry.orientation().turn(quantity));
  }

  @Override
  public void executeForward(int quantity) {
    switch (ferry.orientation()) {
      case E -> executeEast(quantity);
      case W -> executeWest(quantity);
      case N -> executeNorth(quantity);
      case S -> executeSouth(quantity);
    }
  }

}
