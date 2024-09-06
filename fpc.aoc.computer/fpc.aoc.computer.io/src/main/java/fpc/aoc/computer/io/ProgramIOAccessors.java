package fpc.aoc.computer.io;

import lombok.NonNull;

public interface ProgramIOAccessors<I,O> {

    /**
     * @return an object that can be used to write to the program input
     */
    @NonNull
    I programInputAccessor();

    /**
     * @return an object that can be used to read from the program output
     */
    @NonNull
    O programOutputAccessor();

}
