package fpc.aoc.year2021.day15;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2021.day15.struct.Map;
import fpc.aoc.year2021.day15.struct.PathFinder;
import lombok.NonNull;

public abstract class Day15Solver extends SmartSolver<Map> {

    @Override
    protected @NonNull Converter<Map> getConverter() {
        return list -> Map.parse(list,getNbRepetitions());
    }


    protected abstract int getNbRepetitions();

    @Override
    public @NonNull String doSolve(@NonNull Map input) {
        return String.valueOf(new PathFinder().findLowestRisk(input));
    }
}
