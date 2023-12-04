package fpc.aoc.day4;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.List;

public abstract class Day4Solver extends SmartSolver<List<Card>,String> {

    @Override
    protected @NonNull Converter<List<Card>> getConverter() {
        final var parser = new CardParser();
        return s -> s.map(parser::parse).toList();
    }
}
