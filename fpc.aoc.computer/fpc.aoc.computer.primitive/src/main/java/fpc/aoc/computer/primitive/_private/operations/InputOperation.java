package fpc.aoc.computer.primitive._private.operations;

import fpc.aoc.common.Logger;
import fpc.aoc.computer.primitive._private.ExecutionContext;
import lombok.NonNull;

public class InputOperation extends SequentialOperation {

    public InputOperation() {
        super(1);
    }

    @Override
    protected void doPerform(@NonNull ExecutionContext context) {
        Logger.get().log("[%s] Reading input",context.executionName());
        final long value = context.readFromInput();
        Logger.get().log("[%s] Got input value : %d", context.executionName(), value);
        context.setParameter(0, value);
    }
}
