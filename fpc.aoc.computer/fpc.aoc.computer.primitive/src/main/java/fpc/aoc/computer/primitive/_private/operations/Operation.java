package fpc.aoc.computer.primitive._private.operations;

import fpc.aoc.computer.common.AddressingUpdater;
import fpc.aoc.computer.primitive._private.ExecutionContext;
import lombok.NonNull;

public interface Operation {

    @NonNull
    AddressingUpdater perform(ExecutionContext context);

    @NonNull
    static Operation nop() {
        return context -> AddressingUpdater.nop();
    }

}
