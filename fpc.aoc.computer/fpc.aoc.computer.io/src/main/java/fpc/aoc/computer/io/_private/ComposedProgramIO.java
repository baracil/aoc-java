package fpc.aoc.computer.io._private;

import fpc.aoc.computer.io.ProgramIO;
import lombok.NonNull;

public class ComposedProgramIO<I, O> implements ProgramIO<I,O> {

    @NonNull
    private final OutputPort<O,?> outputPort;

    @NonNull
    private final InputPort<I> inputPort;

    public ComposedProgramIO(InputPort<I> inputPort, OutputPort<O,?> outputPort) {
        this.outputPort = outputPort;
        this.inputPort = inputPort;
    }

    @Override
    public String read() {
        return inputPort.read();
    }

    @Override
    public void write(String value) {
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
