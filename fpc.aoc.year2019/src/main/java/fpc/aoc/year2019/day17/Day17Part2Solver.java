package fpc.aoc.year2019.day17;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Nil;
import fpc.aoc.computer.*;
import fpc.aoc.computer.io.InputMultiTransformer;
import fpc.aoc.computer.io.OutputPartBuilder;
import fpc.aoc.computer.io.ProgramIO;
import fpc.aoc.computer.io.ProgramInput;
import fpc.aoc.year2019.day17._private.*;
import lombok.NonNull;

public class Day17Part2Solver extends ProgramBasedSolver {

    public static Solver provider() {
        return new Day17Part2Solver();
    }

    @Override
    protected Object doSolve(Program program) {
        final Camera camera = new Camera(program);
        final Picture picture = camera.takePicture();
        final Path path = FullPathConstructor.constructFrom(picture);
        final MovementRules rules = PathBreaker.breakPath(path);


        final Execution<ProgramInput<String>, Nil> execution = program.launch("Vacuum",
                                                                             createProgramIO(false),
                                                                             Alterations.with(0, "2")
                                                                             );

        rules.feedProgram(execution.programInputAccessor());
        execution.programInputAccessor().write("n\n");

        final ExecutionResult result = execution.waitTermination();

        return result.getLastOutput();
    }




    @NonNull
    private ProgramIO<ProgramInput<String>,Nil> createProgramIO(boolean showToOutput) {
        final OutputPartBuilder<ProgramInput<String>> builder = ProgramIO.controlledInput(InputMultiTransformer.TO_ASCII);
        if (showToOutput) {
            return builder.toStdout(v -> {
                if (v.length() > 2) {
                    return v;
                }
                return String.valueOf((char) Integer.parseInt(v));
            });
        }
        else {
            return builder.ignoreOutput();
        }
    }

}
