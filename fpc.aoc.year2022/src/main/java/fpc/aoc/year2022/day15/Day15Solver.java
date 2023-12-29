package fpc.aoc.year2022.day15;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day15Solver extends SmartSolver<Report> {

    @Override
    protected @NonNull Converter<Report> getConverter() {
        return Converter.forItem(SensorReport::parse).andThen(Report::new);
    }
}
