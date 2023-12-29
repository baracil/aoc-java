package fpc.aoc.year2020.day11;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.GridHelper;
import fpc.aoc.common.SimpleGridHelper;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day11.structures.AdjacentCounter;
import fpc.aoc.year2020.day11.structures.SeatLayoutLife;
import fpc.aoc.year2020.day11.structures.StateEvolutionRule;
import lombok.NonNull;

public abstract class Day11Solver extends SmartSolver<SeatLayoutLife> {

    @Override
    protected @NonNull Converter<SeatLayoutLife> getConverter() {
        return Converter.TO_ARRAY_OF_CHAR.andThen(this::createSeatLayout);
    }

    private @NonNull SeatLayoutLife createSeatLayout(@NonNull ArrayOfChar chars) {
        final GridHelper gridHelper = new SimpleGridHelper(chars.width(),chars.height());
        return new SeatLayoutLife(gridHelper, createEvolutionRule(), createCounter(gridHelper), chars);
    }

    protected abstract @NonNull AdjacentCounter createCounter(@NonNull GridHelper gridHelper);

    protected abstract @NonNull StateEvolutionRule createEvolutionRule();

    @Override
    public @NonNull Long doSolve(@NonNull SeatLayoutLife seatLayoutLife) {
        while (seatLayoutLife.evolving());
        return seatLayoutLife.totalNumberOfOccupiedSeats();
    }

}
