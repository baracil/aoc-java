package fpc.aoc.year2020.day20;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Tools;
import fpc.aoc.year2020.day20.structures.ImageArray;
import fpc.aoc.year2020.day20.structures.ImageTile;

public class Day20Part1Solver extends Day20Solver {

  public static Solver provider() {
    return new Day20Part1Solver();
  }

  @Override
  public Long doSolve(ImageArray imageArray) {
    return imageArray.corners()
        .mapToLong(ImageTile::id)
        .reduce(1, Tools::longProduct);
  }

}
