package fpc.aoc.computer.io._private.input;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Nil;
import fpc.aoc.computer.io._private.InputPort;
import lombok.NonNull;

import java.util.List;

public class InputPortFromList implements InputPort<Nil> {

    @NonNull
    private final List<String> data;

    private int cursor = 0;

    public InputPortFromList(@NonNull List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public String read() {
        if (cursor>=data.size()) {
            throw new AOCException("No more input available");
        };
        return data.get(cursor++);
    }

    @NonNull
    @Override
    public Nil programInputAccessor() {
        return Nil.NIL;
    }
}
