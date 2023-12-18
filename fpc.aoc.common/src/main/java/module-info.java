module fpc.aoc.common {
    requires static lombok;
    requires java.desktop;

    exports fpc.aoc.common;
    exports fpc.aoc.common.rules;
  exports fpc.aoc.common._private;
}