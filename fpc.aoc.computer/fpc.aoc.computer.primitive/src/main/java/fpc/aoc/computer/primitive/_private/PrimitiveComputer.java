package fpc.aoc.computer.primitive._private;

import fpc.aoc.computer.*;
import fpc.aoc.computer.common.ExecutionWithFuture;
import fpc.aoc.computer.io.ProgramIO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;

@RequiredArgsConstructor
public class PrimitiveComputer implements Computer {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool(r -> {
        final var thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    });

    @NonNull
    private final Function<long[],Memory> memoryAllocator;

    @Override
    public Program compile(String code) {
        return new ProgramUsingLong(this,code);
    }

    @NonNull
    public <I,O> Execution<O,I> executeAsync(String executionName, long[] code, ProgramIO<O,I> programIO, Alterations alterations) {
        final Memory memory = prepareMemory(code,alterations);
        final Future<ExecutionResult> future = submitProgram(executionName,memory,programIO);

        return new ExecutionWithFuture<>(executionName, future, programIO);
    }

    @NonNull
    private Memory prepareMemory(long[] values, Alterations alterations) {
        final Memory memory = memoryAllocator.apply(values);
        memory.alter(alterations);
        return memory;
    }

    @NonNull
    private Future<ExecutionResult> submitProgram(String executionName, Memory memory, ProgramIO<?,?> programIO) {
        return EXECUTOR_SERVICE.submit(()->Processor.execute(executionName, memory, programIO));
    }

}
