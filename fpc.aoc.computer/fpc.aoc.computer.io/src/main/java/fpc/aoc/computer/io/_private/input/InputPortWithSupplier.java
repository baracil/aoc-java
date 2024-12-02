package fpc.aoc.computer.io._private.input;

import fpc.aoc.common.Nil;
import lombok.NonNull;

import java.util.function.Supplier;

public class InputPortWithSupplier extends BaseInputPort<Nil> {

    @NonNull
    private final Supplier<? extends String> supplier;

    public InputPortWithSupplier(Supplier<? extends String> supplier) {
        this.supplier = supplier;
    }

    @NonNull
    @Override
    public String read() {
        return supplier.get();
    }

    @NonNull
    @Override
    public Nil programInputAccessor() {
        return Nil.NIL;
    }
}
