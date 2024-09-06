package fpc.aoc.computer.io._private;

import lombok.NonNull;

public interface OutputPort<O, W> {

    /**
     * Used by the program to write to its output
     * @param value the value to write
     */
    void write(@NonNull W value);

    /**
     * @return an object that can be used to read from the program output
     */
    @NonNull
    O programOutputAccessor();

    void transformAndWrite(@NonNull String value);

}
