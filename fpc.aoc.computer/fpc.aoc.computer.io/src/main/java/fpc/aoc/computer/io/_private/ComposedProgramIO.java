package fpc.aoc.computer.io._private;

import fpc.aoc.computer.io.ProgramIO;
import lombok.NonNull;

public class ComposedProgramIO<I, O> implements ProgramIO<I,O> {

    @NonNull
    private final OutputPort<O,?> outputPort;

    @NonNull
    private final InputPort<I> inputPort;

    public ComposedProgramIO(@NonNull InputPort<I> inputPort, @NonNull OutputPort<O,?> outputPort) {
        this.outputPort = outputPort;
        this.inputPort = inputPort;
    }

    @Override
    public @NonNull String read() {
        return inputPort.read();
    }

    @Override
    public void write(@NonNull String value) {
        outputPort.transformAndWrite(value);
    }

    @NonNull
    @Override
    public I programInputAccessor() {
        return inputPort.programInputAccessor();
    }

    @NonNull
    @Override
    public O programOutputAccessor() {
        return outputPort.programOutputAccessor();
    }

}
