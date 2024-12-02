package fpc.aoc.computer.primitive._private.operations;

import fpc.aoc.common.Logger;
import fpc.aoc.computer.primitive._private.ExecutionContext;

public class OutputOperation extends SequentialOperation {

    public OutputOperation() {
        super(1);
    }

    @Override
    protected void doPerform(ExecutionContext context) {
        final long value = context.getParameter(0);
        Logger.get().log("[%s] write output value : %d", context.executionName(),value);
        context.writeToOutput(value);
    }
}
