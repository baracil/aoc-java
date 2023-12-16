package fpc.aoc.day16;

import fpc.aoc.day16.model.BeamComputer;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day16Solver extends SmartSolver<BeamComputer,Long> {

    @Override
    protected @NonNull Converter<BeamComputer> getConverter() {
        return Converter.TO_ARRAY_OF_CHAR.andThen(BeamComputer::new);
    }
}
