package fpc.aoc.year2019.day17._private;

import fpc.aoc.computer.io.ProgramInput;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class MovementRules {

    @NonNull
    private final List<MovementFunction> routine;

    @NonNull
    private final Map<MovementFunction,String> functions;

    @Override
    public String toString() {
        return "MovementRules{" +
               "routine=" + routine +
               ", functions=" + functions +
               '}';
    }

    @NonNull
    public String routineCommand() {
        return routine.stream().map(MovementFunction::code).collect(Collectors.joining(","));
    }

    @NonNull
    public Stream<String> functionCommand() {
        return Arrays.stream(MovementFunction.values()).map(functions::get).filter(Objects::nonNull);
    }

    public void feedProgram(@NonNull ProgramInput<String> programInputAccessor) {
        programInputAccessor.write(routineCommand());
        programInputAccessor.write("\n");
        functionCommand().forEach(f -> {
            programInputAccessor.write(f);
            programInputAccessor.write("\n");
        });
    }

}
