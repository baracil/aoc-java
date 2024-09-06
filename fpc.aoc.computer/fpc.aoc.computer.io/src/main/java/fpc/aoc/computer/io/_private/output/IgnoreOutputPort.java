package fpc.aoc.computer.io._private.output;

import fpc.aoc.common.Nil;
import lombok.NonNull;

public class IgnoreOutputPort extends BaseOutputPort<Nil,String> {

    public IgnoreOutputPort() {
        super(s -> s);
    }

    @NonNull
    @Override
    public Nil programOutputAccessor() {
        return Nil.NIL;
    }

    @Override
    public void write(@NonNull String value) {
        //ignored
    }

}
