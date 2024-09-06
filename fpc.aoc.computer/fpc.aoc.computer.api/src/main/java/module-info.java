import fpc.aoc.computer.ComputerFactory;

module fpc.aoc.computer.api {
    requires static lombok;

    requires fpc.aoc.common;
    requires transitive fpc.aoc.computer.io;
    requires fpc.aoc.input;

    exports fpc.aoc.computer;

    uses ComputerFactory;
}
