package fpc.aoc.input;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.api.AOCProblemId;
import fpc.aoc.api.Solver;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

/**
 * @param <S> the type of the solution
 * @param <I> the type of the input
 */
@RequiredArgsConstructor
public class AOCProblemUsingSolver<I, S> implements AOCProblem<S> {


    public static <I, S> @NonNull AOCProblem<S> create(
            @NonNull Solver<I, S> solver,
            @NonNull Input<Stream<String>> input,
            @NonNull Converter<? extends I> converter
    ) {
        final var day = solver.day();
        final var part = solver.part();
        return new AOCProblemUsingSolver<>(
                day.createIdWith(part),
                input.map(converter),
                solver
        );
    }

    public static <I, S> @NonNull AOCProblem<S> create(
            @NonNull Solver<I, S> solver,
            @NonNull Converter<? extends I> converter
    ) {
        return create(solver, new ResourceFile(solver.day()), converter);
    }

    @NonNull
    @Getter
    private final AOCProblemId id;

    private final Input<I> input;

    private final Solver<I, S> solver;

    @Override
    public @NonNull S solve() {
        final I input = this.input.readData();
        return solver.solve(input);
    }

    @Override
    public String toString() {
        return "AOCProblem{" +id.day()+" "+id.part()+"}";
    }
}
