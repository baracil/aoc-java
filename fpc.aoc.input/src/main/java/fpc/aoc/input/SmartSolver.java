package fpc.aoc.input;

import fpc.aoc.api.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public abstract class SmartSolver<I,S> implements Solver<I,S> {

    private static final Pattern DAY_PART = Pattern.compile("Day(?<day>[0-9]+)Part(?<part>[12]).+");

    @Getter
    private final @NonNull Day day;
    @Getter
    private final @NonNull Part part;

    public SmartSolver() {
        final Matcher matcher = DAY_PART.matcher(this.getClass().getSimpleName());
        if (!matcher.matches()) {
            throw new RuntimeException("Solver must provide DAY and PART by parameter or by having its name of the form DayXXParY");
        }
        this.day = Day.parse(matcher.group("day"));
        this.part = Part.parse(matcher.group("part"));
    }

    /**
     * @return the converter required to convert the input data of the problem to the required type
     */
    protected abstract @NonNull Converter<I> getConverter();


    /**
     * @return an {@link AOCProblem} using this solver and the resources associated as input
     */
    public @NonNull AOCProblem<S> createProblem() {
        final var problem = AOCProblemUsingSolver.create(this, this.getConverter());
        if (this.isSkipped()) {
            return new SkippedAOCProblem<>(problem);
        }
        return problem;
    }

    /**
     * @return an {@link AOCProblem} using this solver and the provided multi lines as input
     */
    public @NonNull AOCProblem<S> createProblem(@NonNull String multiLines) {
        return AOCProblemUsingSolver.create(this, new MultiLines(multiLines), this.getConverter());
    }

}
