package fpc.aoc.computer.primitive._private.operations;

import fpc.aoc.common.Tools;
import fpc.aoc.computer.common.AddressingUpdater;
import fpc.aoc.computer.primitive._private.ExecutionContext;

/**
 * @author Bastien Aracil
 **/
public class AdjustRelativeBase implements Operation {

    public AdjustRelativeBase() {
    }

    @Override
    public AddressingUpdater perform(ExecutionContext context) {
        final long value = context.getParameter(0);
        return a -> a.addToAbsolute(1).addToRelative(Tools.toInt(value));
    }
}
