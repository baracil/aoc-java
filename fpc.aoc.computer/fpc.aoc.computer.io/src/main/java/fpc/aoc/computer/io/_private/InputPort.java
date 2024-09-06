package fpc.aoc.computer.io._private;

import lombok.NonNull;

public interface InputPort<I> {

    /**
     * Use by the program to read its input
     * @return the value read from the input
     */
    @NonNull
    String read();

    /**
     * @return an object that can be used to write to the program input
     */
    @NonNull
    I programInputAccessor();


}
