package fpc.aoc.computer.common;

import fpc.aoc.common.AOCException;
import fpc.aoc.computer.Execution;
import fpc.aoc.computer.ExecutionResult;
import fpc.aoc.computer.io.ProgramIOAccessors;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RequiredArgsConstructor
public class ExecutionWithFuture<I,O> implements Execution<O,I> {

    @NonNull
    @Getter
    private final String name;

    @NonNull
    private final Future<ExecutionResult> future;

    private final CompletableFuture<Void> completionStage;

    @NonNull
    private final ProgramIOAccessors<O,I> programIOAccessors;

    public ExecutionWithFuture(
            @NonNull String name,
            @NonNull Future<ExecutionResult> future,
            @NonNull ProgramIOAccessors<O,I> programIOAccessors
    ) {
        this.name = name;
        this.future = future;
        this.completionStage = CompletableFuture.runAsync(this::silentlyWaitForTermination);
        this.programIOAccessors = programIOAccessors;
    }

    @NonNull
    public CompletionStage<Void> whenDone(@NonNull Runnable action) {
        return completionStage.whenComplete((r,t)->action.run());
    }

    @NonNull
    public ExecutionResult waitTermination() {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            throw new AOCException("Execution error "+e.getMessage(),e);
        }
    }

    @NonNull
    @Override
    public O programInputAccessor() {
        return programIOAccessors.programInputAccessor();
    }

    @NonNull
    @Override
    public I programOutputAccessor() {
        return programIOAccessors.programOutputAccessor();
    }

    private void silentlyWaitForTermination() {
        try {
            waitTermination();
        } catch (Throwable ignored) {
        }
    }


    public void interrupt() {
        future.cancel(true);
    }

    public boolean isDone() {
        return future.isDone();
    }

}
