package fpc.aoc.computer.io._private.output;

import fpc.aoc.computer.io.OutputTransformer;
import fpc.aoc.computer.io.ProgramOutput;
import lombok.NonNull;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ControllerOutputPort<T> extends BaseOutputPort<ProgramOutput<T>,T> {

    private final BlockingDeque<T> bridge = new LinkedBlockingDeque<>();

    public ControllerOutputPort(OutputTransformer<T> outputTransformer) {
        super(outputTransformer);
    }

    @Override
    public void write(T value) {
        bridge.addLast(value);
    }

    @NonNull
    @Override
    public ProgramOutput<T> programOutputAccessor() {
        return bridge::takeFirst;
    }
}
