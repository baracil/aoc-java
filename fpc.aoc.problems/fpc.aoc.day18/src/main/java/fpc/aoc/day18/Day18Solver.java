package fpc.aoc.day18;

import fpc.aoc.day18.model.InstructionParser;
import fpc.aoc.day18.model.Polygon;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day18Solver extends SmartSolver<Polygon,Long> {

    public abstract InstructionParser getParser();

    @Override
    protected @NonNull Converter<Polygon> getConverter() {
        final var parser = getParser();
        return s -> Polygon.from(s.map(parser::parse).toList());
    }

    @Override
    public @NonNull Long solve(@NonNull Polygon input) {
        final var area = input.area();
        final var perimeter = input.perimeter();

        final var inside = area-perimeter/2+1;

        return inside+perimeter;
    }
}
