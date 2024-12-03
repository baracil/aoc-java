import fpc.aoc.computer.ComputerFactory;

module fpc.aoc.computer.primitive {
    requires static lombok;

    requires fpc.aoc.common;
    requires fpc.aoc.computer.api;
    requires fpc.aoc.computer.commom;

    exports fpc.aoc.computer.primitive;

    provides ComputerFactory with fpc.aoc.computer.primitive.FixSizeLongValueComputerFactory, fpc.aoc.computer.primitive.VariableSizeLongValueComputerFactory;
}
