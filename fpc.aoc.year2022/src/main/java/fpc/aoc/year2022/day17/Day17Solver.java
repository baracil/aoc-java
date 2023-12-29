package fpc.aoc.year2022.day17;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day17Solver extends SmartSolver<Game> {

    @Override
    protected @NonNull Converter<Game> getConverter() {
        return Converter.FIRST_LINE.andThen(Jet::new).andThen(Game::new);
    }
}
