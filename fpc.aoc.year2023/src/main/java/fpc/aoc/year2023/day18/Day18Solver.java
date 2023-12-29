package fpc.aoc.year2023.day18;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2023.day18.model.InstructionParser;
import fpc.aoc.year2023.day18.model.Polygon;
import lombok.NonNull;

public abstract class Day18Solver extends SmartSolver<Polygon> {

    public abstract InstructionParser getParser();

    @Override
    protected @NonNull Converter<Polygon> getConverter() {
        final var parser = getParser();
        return Converter.forItem(parser::parse).andThen(Polygon::from);
    }

    @Override
    public @NonNull Long doSolve(@NonNull Polygon input) {
        final var area = input.area();
        final var perimeter = input.perimeter();

        final var inside = area-perimeter/2+1;

        return inside+perimeter;
    }
}
