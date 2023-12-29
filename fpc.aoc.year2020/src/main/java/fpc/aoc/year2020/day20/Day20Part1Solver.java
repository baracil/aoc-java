package fpc.aoc.year2020.day20;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Tools;
import fpc.aoc.year2020.day20.structures.ImageArray;
import fpc.aoc.year2020.day20.structures.ImageTile;
import lombok.NonNull;

public class Day20Part1Solver extends Day20Solver {

  public static @NonNull Solver provider() {
    return new Day20Part1Solver();
  }

  @Override
  public @NonNull Long doSolve(@NonNull ImageArray imageArray) {
    return imageArray.corners()
        .mapToLong(ImageTile::id)
        .reduce(1, Tools::longProduct);
  }

}
