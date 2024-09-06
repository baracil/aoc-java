package fpc.aoc.computer;

import fpc.aoc.computer.io.ProgramIO;
import lombok.NonNull;

public interface Program {

    @NonNull
    <I,O> Execution<O,I> launch(
            @NonNull String executionName,
            @NonNull ProgramIO<O,I> pipe,
            @NonNull Alterations alterations
    );

    @NonNull
    default <I,O> Execution<O,I> launch(
            @NonNull String executionName,
            @NonNull ProgramIO<O,I> programIO
            ) {
        return launch(executionName, programIO, Alterations.none());
    }

    @NonNull
    default ExecutionResult launchAndWait(
            @NonNull String executionName,
            @NonNull ProgramIO<?,?> programIO,
            @NonNull Alterations alterations
    ) {
        return launch(executionName, programIO, alterations).waitTermination();
    }

    @NonNull
    default ExecutionResult launchAndWait(
            @NonNull String executionName,
            @NonNull ProgramIO<?,?> programIO
            ) {
        return launch(executionName, programIO, Alterations.none()).waitTermination();
    }


    @NonNull
    default ExecutionResult launchAndWait(
            @NonNull String executionName,
            @NonNull Alterations alterations
            ) {
        return launch(executionName, ProgramIO.noInput().ignoreOutput(), alterations).waitTermination();
    }

    @NonNull
    default ExecutionResult launchAndWait(
            @NonNull String executionName
            ) {
        return launch(executionName, ProgramIO.noInput().ignoreOutput(), Alterations.none()).waitTermination();
    }


}
