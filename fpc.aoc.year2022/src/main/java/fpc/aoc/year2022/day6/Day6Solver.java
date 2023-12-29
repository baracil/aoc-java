package fpc.aoc.year2022.day6;

import fpc.aoc.common.AOCException;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Day6Solver extends SmartSolver<String> {

    @Override
    protected @NonNull Converter<String> getConverter() {
        return Converter.FIRST_LINE;
    }

    private final int markerLength;

    @Override
    public @NonNull Integer doSolve(@NonNull String input) {
        final var finder = new MarkerFinder(markerLength);


        for (int i = 0; i < input.length(); i++) {
            final var chr =  input.charAt(i);
            finder.handleChar(chr);
            if (finder.found()) {
                return finder.idx();
            }
        }

        throw new AOCException("Cannot solve!");
    }

}
