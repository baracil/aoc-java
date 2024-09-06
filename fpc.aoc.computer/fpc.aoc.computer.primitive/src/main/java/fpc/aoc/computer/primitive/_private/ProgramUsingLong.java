package fpc.aoc.computer.primitive._private;

import fpc.aoc.computer.Alterations;
import fpc.aoc.computer.Execution;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.io.ProgramIO;
import lombok.NonNull;

import java.util.Arrays;

public class ProgramUsingLong implements Program {

    private final PrimitiveComputer computer;

    private final long[] code;

    public ProgramUsingLong(@NonNull PrimitiveComputer computer, @NonNull String code) {
        this.computer = computer;
        this.code = Arrays.stream(code.split(",")).mapToLong(Long::parseLong).toArray();
    }

    @Override
    public <I,O>  @NonNull Execution<O,I> launch(@NonNull String executionName, @NonNull ProgramIO<O,I> programIO, @NonNull Alterations alterations) {
        return computer.executeAsync(executionName,code.clone(),programIO, alterations);
    }
}
