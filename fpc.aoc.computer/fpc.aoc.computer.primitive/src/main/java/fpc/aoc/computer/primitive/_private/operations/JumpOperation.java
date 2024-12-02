package fpc.aoc.computer.primitive._private.operations;

import fpc.aoc.common.Tools;
import fpc.aoc.computer.common.AddressingUpdater;
import fpc.aoc.computer.primitive._private.ExecutionContext;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.LongPredicate;

@RequiredArgsConstructor
public class JumpOperation implements Operation {

    @NonNull
    private final LongPredicate predicate;

    @Override
    public AddressingUpdater perform(ExecutionContext context) {
        final long p0 = context.getParameter(0);
        final long p1 = context.getParameter(1);
        final int address = Tools.toInt(p1);
        if (predicate.test(p0)) {
            return AddressingUpdater.jumpAbsolute(address);
        }
        else {
            return AddressingUpdater.skipAbsolute(2);
        }
    }
}
