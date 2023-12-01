import fpc.aoc.api.AOCProblem;

module fpc.aoc.launcher {
    requires static lombok;

    requires fpc.aoc.api;
    requires fpc.aoc.common;

    requires com.google.common;

    exports fpc.aoc.launcher;
    uses AOCProblem;
}
