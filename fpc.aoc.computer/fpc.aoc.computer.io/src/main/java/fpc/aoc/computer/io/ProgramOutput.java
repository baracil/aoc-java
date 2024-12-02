package fpc.aoc.computer.io;

import fpc.aoc.computer.io._private.PrivatePipe;
import lombok.NonNull;

import java.util.function.Consumer;

public interface ProgramOutput<T> extends InterruptableOutput<T> {

    /**
     * Read a value from the program output
     * @return  the read value
     */
    @NonNull
    T read() throws InterruptedException;

    @NonNull
    default Pipe pipeTo(ProgramInput<? super T> input) {
        return new PrivatePipe<>(input::write,this);
    }

    @NonNull
    default Pipe pipeTo(Consumer<? super T> input) {
        return new PrivatePipe<>(input,this);
    }
}
