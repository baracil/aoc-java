package fpc.aoc.computer.io;

public interface ProgramInput<T> {

    /**
     * Write a value to the program input
     * @param value the value to write
     */
    void write(T value);


}
