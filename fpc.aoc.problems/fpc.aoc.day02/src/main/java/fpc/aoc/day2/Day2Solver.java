package fpc.aoc.day2;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public abstract class Day2Solver extends SmartSolver<Stream<Game>, Integer> {

    @Override
    protected @NonNull Converter<Stream<Game>> getConverter() {
        return s->s.map(Game::parse);
    }
}
