import fpc.aoc.computer.ComputerFactory;
import fpc.aoc.computer.primitive.FixSizeLongValueComputerFactory;
import fpc.aoc.computer.primitive.VariableSizeLongValueComputerFactory;

module fpc.aoc.computer.primitive {
    requires static lombok;

    requires fpc.aoc.common;
    requires fpc.aoc.computer.api;
    requires fpc.aoc.computer.commom;

    exports fpc.aoc.computer.primitive;

    provides ComputerFactory with FixSizeLongValueComputerFactory, VariableSizeLongValueComputerFactory;
}
