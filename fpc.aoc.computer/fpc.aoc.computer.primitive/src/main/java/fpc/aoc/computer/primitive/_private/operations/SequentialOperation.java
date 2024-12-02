package fpc.aoc.computer.primitive._private.operations;

import fpc.aoc.computer.common.AddressingUpdater;
import fpc.aoc.computer.primitive._private.ExecutionContext;

public abstract class SequentialOperation implements Operation {

    private final int numberOfParameters;

    public SequentialOperation(int numberOfParameters) {
        this.numberOfParameters = numberOfParameters;
    }

    @Override
    public AddressingUpdater perform(ExecutionContext context) {
        doPerform(context);
        return AddressingUpdater.skipAbsolute(numberOfParameters);
    }

    protected abstract void doPerform(ExecutionContext context);
}
