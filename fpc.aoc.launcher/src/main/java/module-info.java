module fpc.aoc.launcher {
  requires static lombok;

  requires fpc.aoc.api;
  requires fpc.aoc.common;
  requires fpc.aoc.input;

  exports fpc.aoc.launcher;

  uses fpc.aoc.api.Solver;
}
