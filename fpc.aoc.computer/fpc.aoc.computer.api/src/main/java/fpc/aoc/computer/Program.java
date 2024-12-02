package fpc.aoc.computer;

import fpc.aoc.computer.io.ProgramIO;
import lombok.NonNull;

public interface Program {

    @NonNull
    <I,O> Execution<O,I> launch(
            String executionName,
            ProgramIO<O,I> pipe,
            Alterations alterations
    );

    @NonNull
    default <I,O> Execution<O,I> launch(
            String executionName,
            ProgramIO<O,I> programIO
            ) {
        return launch(executionName, programIO, Alterations.none());
    }

    @NonNull
    default ExecutionResult launchAndWait(
            String executionName,
            ProgramIO<?,?> programIO,
            Alterations alterations
    ) {
        return launch(executionName, programIO, alterations).waitTermination();
    }

    @NonNull
    default ExecutionResult launchAndWait(
            String executionName,
            ProgramIO<?,?> programIO
            ) {
        return launch(executionName, programIO, Alterations.none()).waitTermination();
    }


    @NonNull
    default ExecutionResult launchAndWait(
            String executionName,
            Alterations alterations
            ) {
        return launch(executionName, ProgramIO.noInput().ignoreOutput(), alterations).waitTermination();
    }

    @NonNull
    default ExecutionResult launchAndWait(
            String executionName
            ) {
        return launch(executionName, ProgramIO.noInput().ignoreOutput(), Alterations.none()).waitTermination();
    }


}
