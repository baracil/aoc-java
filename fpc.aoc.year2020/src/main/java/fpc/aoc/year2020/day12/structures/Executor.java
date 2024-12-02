package fpc.aoc.year2020.day12.structures;

public interface Executor {

  void executeEast(int quantity);

  void executeWest(int quantity);

  void executeNorth(int quantity);

  void executeSouth(int quantity);

  void executeLeft(int quantity);

  void executeRight(int quantity);

  void executeForward(int quantity);

  default void execute(Movement movement) {
    movement.operation().execute(this, movement.quantity());
  }

}
