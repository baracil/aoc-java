package fpc.aoc.computer.io;

import lombok.NonNull;

/**
 * @author Bastien Aracil
 **/
public interface InterruptableOutput<T> {

    @NonNull
    T read() throws InterruptedException;

}
