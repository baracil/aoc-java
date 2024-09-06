package fpc.aoc.computer.io._private.input;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Nil;
import fpc.aoc.computer.io._private.InputPort;
import lombok.NonNull;

public class NoInputPort implements InputPort<Nil> {

    @Override
    public @NonNull String read() {
        throw new AOCException("No input available");
    }

    @NonNull
    @Override
    public Nil programInputAccessor() {
        return Nil.NIL;
    }

}
