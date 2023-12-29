package fpc.aoc.year2020.day12.structures;

import fpc.aoc.common.AOCException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.BiConsumer;

@RequiredArgsConstructor
public enum Operation {
  E(Executor::executeEast),
  W(Executor::executeWest),
  N(Executor::executeNorth),
  S(Executor::executeSouth),
  L(Executor::executeLeft),
  R(Executor::executeRight),
  F(Executor::executeForward),
  ;

  private final @NonNull BiConsumer<Executor, Integer> action;

  public void execute(@NonNull Executor executor, int quantity) {
    action.accept(executor, quantity);
  }

  public static @NonNull Operation parse(@NonNull String oper) {
    return switch (oper) {
      case "E" -> E;
      case "W" -> W;
      case "N" -> N;
      case "S" -> S;
      case "L" -> L;
      case "R" -> R;
      case "F" -> F;
      default -> throw new AOCException("Cannot parse operation '" + oper + "'");
    };
  }

}
