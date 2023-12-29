package fpc.aoc.year2020.day19;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day19.structures.Day19Input;
import fpc.aoc.year2020.day19.structures.Tester;
import lombok.NonNull;

public abstract class Day19Solver extends SmartSolver<Day19Input> {

    @Override
    protected @NonNull Converter<Day19Input> getConverter() {
        return Day19Input::parse;
    }

    protected abstract @NonNull Day19Input modifyInput(@NonNull Day19Input input);

    @Override
    public final @NonNull Long doSolve(@NonNull Day19Input input) {
        final var modifiedInput = modifyInput(input);
        final var tester = new Tester(modifiedInput.rules());

        return modifiedInput.messages().stream().filter(tester).count();
    }
}
