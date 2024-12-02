package fpc.aoc.computer.io._private;

import fpc.aoc.computer.io.InterruptableOutput;
import fpc.aoc.computer.io.Pipe;
import lombok.NonNull;

import java.util.function.Consumer;

public class PrivatePipe<T> implements Pipe {

    @NonNull
    private final Consumer<? super T> input;

    @NonNull
    private final InterruptableOutput<? extends T> output;

    private final Thread thread;

    public PrivatePipe(
            Consumer<? super T> input,
            InterruptableOutput<? extends T> output) {
        this.input = input;
        this.output = output;
        this.thread = new Thread(new Runner());
        this.thread.setDaemon(true);
        this.thread.start();
    }

    @Override
    public void close() {
        this.thread.interrupt();
    }

    private class Runner implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    input.accept(output.read());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}
