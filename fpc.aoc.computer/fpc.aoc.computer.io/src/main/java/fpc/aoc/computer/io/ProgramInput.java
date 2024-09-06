package fpc.aoc.computer.io;

import lombok.NonNull;

public interface ProgramInput<T> {

    /**
     * Write a value to the program input
     * @param value the value to write
     */
    void write(@NonNull T value);


}
