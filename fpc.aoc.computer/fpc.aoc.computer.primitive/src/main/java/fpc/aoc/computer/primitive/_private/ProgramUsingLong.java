package fpc.aoc.computer.primitive._private;

import fpc.aoc.computer.Alterations;
import fpc.aoc.computer.Execution;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.io.ProgramIO;

import java.util.Arrays;

public class ProgramUsingLong implements Program {

    private final PrimitiveComputer computer;

    private final long[] code;

    public ProgramUsingLong(PrimitiveComputer computer, String code) {
        this.computer = computer;
        this.code = Arrays.stream(code.split(",")).mapToLong(Long::parseLong).toArray();
    }

    @Override
    public <I,O>  Execution<O,I> launch(String executionName, ProgramIO<O,I> programIO, Alterations alterations) {
        return computer.executeAsync(executionName,code.clone(),programIO, alterations);
    }
}
