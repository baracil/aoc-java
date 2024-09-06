package fpc.aoc.computer.io._private.input;

import fpc.aoc.common.AOCException;
import fpc.aoc.computer.io.InputMultiTransformer;
import fpc.aoc.computer.io.InputTransform;
import fpc.aoc.computer.io.ProgramInput;
import fpc.aoc.computer.io._private.InputPort;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@RequiredArgsConstructor
public class ControllerInputPort<T> implements InputPort<ProgramInput<T>> {

    @NonNull
    private final BlockingDeque<String> bridge = new LinkedBlockingDeque<>();

    private final InputMultiTransformer<T> inputTransform;

    public ControllerInputPort(@NonNull InputTransform<T> singleValueTransformer) {
        this(singleValueTransformer.toMulti());
    }

    @NonNull
    @Override
    public String read() {
        try {
            return bridge.takeFirst();
        } catch (InterruptedException e) {
            throw new AOCException("Input reading interrupted", e);
        }
    }

    @NonNull
    @Override
    public ProgramInput<T> programInputAccessor() {
        return value -> inputTransform.apply(value).forEach(bridge::addLast);
    }
}
