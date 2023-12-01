module fpc.aoc.common {
    requires static lombok;
    requires java.desktop;

    requires com.google.common;

    exports fpc.aoc.common;
    exports fpc.aoc.common.rules;
}