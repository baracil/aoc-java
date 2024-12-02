package fpc.aoc.year2019.day24;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2019.day24._private.BugColony;

/**
 * .......  0   -    6
 * .xxxxx.  7  8-12 13
 * .xxxxx. 14 15-19 20
 * .xxxxx. 21 22-36 27
 * .xxxxx. 28 29-33 34
 * .xxxxx. 35 36-40 41
 * ....... 42   -   48
 *
 * @author Bastien Aracil
 **/
public abstract class Day24Solver extends SmartSolver<BugColony> {


  @Override
  protected Converter<BugColony> getConverter() {
    return BugColony::create;
  }


}
