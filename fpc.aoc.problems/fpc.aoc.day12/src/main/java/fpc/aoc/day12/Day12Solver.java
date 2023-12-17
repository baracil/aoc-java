package fpc.aoc.day12;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class Day12Solver extends SmartSolver<Stream<Row>,Long> {


    @Override
    protected @NonNull Converter<Stream<Row>> getConverter() {
        return s -> s.map(Row::parse);
    }


    protected abstract Row prepareRow(Row row);

    @Override
    public @NonNull Long solve(@NonNull Stream<Row> input) {
        return input.map(this::prepareRow).mapToLong(ArrangementCounter::count).sum();
    }
}
