package fpc.aoc.year2023.day15;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.Arrays;
import java.util.List;

public class Day15Part2Solver extends Day15Solver {

  public static @NonNull Solver provider() {
    return new Day15Part2Solver();
  }


  @Override
  public @NonNull Object doSolve(@NonNull List<String> input) {
    final var computer = new HashComputer();
    final var boxes = new Box[256];
    for (int i = 0; i < boxes.length; i++) {
      boxes[i] = new Box(i + 1);
    }

    for (String s : input) {
      final var idx = s.indexOf("=");
      if (idx < 0) {
        final var name = s.substring(0, s.length() - 1);

        final var hash = computer.compute(name);
        boxes[hash].removeLens(name);
      } else {
        final var name = s.substring(0, idx);
        final var focalLength = Integer.parseInt(s.substring(idx + 1));

        final var hash = computer.compute(name);
        boxes[hash].addLens(name, focalLength);
      }
    }

    return Arrays.stream(boxes).mapToLong(Box::focusPower).sum();

  }

}
