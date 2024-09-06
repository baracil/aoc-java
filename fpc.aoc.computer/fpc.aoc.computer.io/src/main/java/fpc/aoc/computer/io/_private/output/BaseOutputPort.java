package fpc.aoc.computer.io._private.output;

import fpc.aoc.computer.io.OutputTransformer;
import fpc.aoc.computer.io._private.OutputPort;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BaseOutputPort<I,W> implements OutputPort<I,W> {

    @NonNull
    private final OutputTransformer<W> outputTransformer;

    @Override
    public void transformAndWrite(@NonNull String value) {
        write(outputTransformer.apply(value));
    }
}
