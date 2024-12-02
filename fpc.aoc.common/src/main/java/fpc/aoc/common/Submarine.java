package fpc.aoc.common;

import lombok.Value;

@Value
public class Submarine {

  Position position;
  int aim;

  public static Submarine startPosition() {
    return new Submarine(new Position(0, 0), 0);
  }

  public int horizontal() {
    return position.x();
  }

  public int depth() {
    return -position.y();
  }

  public Submarine withStupidCommand(SubCommand command) {
    return switch (command) {
      case SubCommand.Forward forward -> new Submarine(position.translate(forward.amount(), 0), aim);
      case SubCommand.Down down -> new Submarine(position.translate(0, -down.amount()), aim);
      case SubCommand.Up up -> new Submarine(position.translate(0, up.amount()), aim);
    };
  }

  public Submarine withCommand(SubCommand command) {
    return switch (command) {
      case SubCommand.Forward forward ->
          new Submarine(position.translate(forward.amount(), aim * forward.amount()), aim);
      case SubCommand.Down down -> new Submarine(position, aim - down.amount());
      case SubCommand.Up up -> new Submarine(position, aim + up.amount());
    };
  }
}
