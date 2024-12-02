package fpc.aoc.computer.io._private.output;

import fpc.aoc.common.Nil;
import lombok.NonNull;

import java.util.function.Consumer;

public class SimpleConsumeOutput extends BaseOutputPort<Nil,String> {

    private final Consumer<? super String> consumer;

    public SimpleConsumeOutput(
            Consumer<? super String> consumer) {
        super(s -> s);
        this.consumer = consumer;
    }

    @Override
    public void write(String value) {
        consumer.accept(value);
    }

    @NonNull
    @Override
    public Nil programOutputAccessor() {
        return Nil.NIL;
    }
}
