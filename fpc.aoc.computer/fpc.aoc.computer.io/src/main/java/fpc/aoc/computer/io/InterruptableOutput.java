package fpc.aoc.computer.io;

import lombok.NonNull;

/**
 * @author perococco
 **/
public interface InterruptableOutput<T> {

    @NonNull
    T read() throws InterruptedException;

}
