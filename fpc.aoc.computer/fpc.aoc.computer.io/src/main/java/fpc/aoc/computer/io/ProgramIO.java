package fpc.aoc.computer.io;

import fpc.aoc.common.Nil;
import fpc.aoc.computer.io._private.input.ControllerInputPort;
import fpc.aoc.computer.io._private.input.InputPortFromList;
import fpc.aoc.computer.io._private.input.InputPortWithSupplier;
import fpc.aoc.computer.io._private.input.NoInputPort;
import lombok.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public interface ProgramIO<I, O> extends ProgramIOAccessors<I,O> {

    /**
     * used by the program to read from its input
     * @return the read value
     */
    @NonNull
    String read();

    /**
     * Used by the program to write to its output
     * @param value the value to write
     */
    void write(@NonNull String value);


    //----------------------------------
    @NonNull
    static OutputPartBuilder<Nil> noInput() {
        return new OutputPartBuilder<>(new NoInputPort());
    }

    @NonNull
    static OutputPartBuilder<Nil> withSupplier(@NonNull Supplier<? extends String> supplier) {
        return new OutputPartBuilder<>(new InputPortWithSupplier(supplier));
    }

    @NonNull
    static OutputPartBuilder<Nil> fromStdin() {
        return fromStdin(InputMultiTransformer.TO_ASCII);
    }

    @NonNull
    static OutputPartBuilder<Nil> fromStdin(@NonNull InputMultiTransformer<String> transform) {
        return new OutputPartBuilder<>(new StdinInputPort(transform));
    }

    @NonNull
    static <T> OutputPartBuilder<Nil> withSupplier(@NonNull Supplier<T> supplier, @NonNull InputTransform<T> transform) {
        return withSupplier(() -> transform.apply(supplier.get()));
    }


    @NonNull
    static OutputPartBuilder<Nil> fromList(@NonNull String... values) {
        return new OutputPartBuilder<>(new InputPortFromList(List.of(values)));
    }

    @NonNull
    static <T> OutputPartBuilder<Nil> fromList(@NonNull InputMultiTransformer<T> transformer, @NonNull T... values) {
        final var strs = Arrays.stream(values).flatMap(r -> transformer.apply(r).stream()).toList();

        return new OutputPartBuilder<>(new InputPortFromList(strs));
    }

    @NonNull
    static <T> OutputPartBuilder<ProgramInput<T>> controlledInput(@NonNull InputTransform<T> transformer) {
        return controlledInput(transformer.toMulti());
    }

    @NonNull
    static <R> OutputPartBuilder<ProgramInput<R>> controlledInput(@NonNull InputMultiTransformer<R> transform) {
        return new OutputPartBuilder<>(new ControllerInputPort<>(transform));
    }

    @NonNull
    static OutputPartBuilder<ProgramInput<String>> controlledInput() {
        return controlledInput(InputTransform.NONE);
    }

    @NonNull
    static <R,W> ProgramIO<ProgramInput<R>,ProgramOutput<W>> duplex(@NonNull InputTransform<R> inputTransform,
            @NonNull OutputTransformer<W> outputTransformer) {
        return duplex(inputTransform.toMulti(),outputTransformer);
    }

    @NonNull
    static <R,W> ProgramIO<ProgramInput<R>,ProgramOutput<W>> duplex(@NonNull InputMultiTransformer<R> inputTransform,
            @NonNull OutputTransformer<W> outputTransformer) {
        return controlledInput(inputTransform).controlledOutput(outputTransformer);
    }

    @NonNull
    static ProgramIO<ProgramInput<String>,ProgramOutput<String>> duplex() {
        return duplex(InputTransform.NONE, OutputTransformer.NONE);
    }


}
