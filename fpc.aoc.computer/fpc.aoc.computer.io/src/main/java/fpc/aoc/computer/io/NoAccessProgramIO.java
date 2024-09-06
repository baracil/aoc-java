package fpc.aoc.computer.io;

import fpc.aoc.common.Nil;
import lombok.NonNull;

/**
 * @author perococco
 **/
public abstract class NoAccessProgramIO implements ProgramIO<Nil,Nil> {

    @NonNull
    @Override
    public Nil programInputAccessor() {
        return Nil.NIL;
    }

    @NonNull
    @Override
    public Nil programOutputAccessor() {
        return Nil.NIL;
    }
}
