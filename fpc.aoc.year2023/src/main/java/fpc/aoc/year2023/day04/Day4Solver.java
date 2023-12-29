package fpc.aoc.year2023.day04;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.List;

public abstract class Day4Solver extends SmartSolver<List<Card>> {

    @Override
    protected @NonNull Converter<List<Card>> getConverter() {
        return Converter.forItem(new CardParser());
    }
}
