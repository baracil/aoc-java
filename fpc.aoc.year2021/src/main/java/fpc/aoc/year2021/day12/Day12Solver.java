package fpc.aoc.year2021.day12;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2021.day12.struct.Connection;
import fpc.aoc.year2021.day12.struct.Graph;
import fpc.aoc.year2021.day12.struct.PathCounter;
import fpc.aoc.year2021.day12.struct.RecursiveMode;
import lombok.NonNull;

public abstract class Day12Solver extends SmartSolver<Graph> {

    @Override
    protected @NonNull Converter<Graph> getConverter() {
        return s -> s.stream().map(Connection::parse).collect(Graph.COLLECTOR);
    }

    @Override
    public @NonNull Long doSolve(@NonNull Graph graph) {
        return PathCounter.count(graph,getRecursiveMode());
    }

    protected abstract RecursiveMode getRecursiveMode();
}
