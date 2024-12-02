package fpc.aoc.computer.io._private.output;

import fpc.aoc.common.Nil;
import fpc.aoc.computer.io.OutputTransformer;
import lombok.NonNull;

public class ToSdtOutputPort<T> extends BaseOutputPort<Nil,T> {

    public ToSdtOutputPort(OutputTransformer<T> outputTransformer) {
        super(outputTransformer);
    }

    @Override
    public void write(T value) {
        System.out.print(value);
    }

    @NonNull
    @Override
    public Nil programOutputAccessor() {
        return Nil.NIL;
    }

}
