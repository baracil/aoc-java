package fpc.aoc.computer.io._private;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public class OutputPipeWrapper<T> implements Output {

    @NonNull
    private final OutputPort<?,T> wrapped;

    @NonNull
    private final Function<? super String, ? extends T> fromString;

    @Override
    public void write(String value) {
        wrapped.write(fromString.apply(value));
    }

}
