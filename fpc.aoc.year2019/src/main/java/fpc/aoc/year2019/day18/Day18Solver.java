package fpc.aoc.year2019.day18;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2019.day18._private.Maze;
import fpc.aoc.year2019.day18._private.algo.KeyCollector;
import lombok.NonNull;

import java.util.stream.Collector;

public abstract class Day18Solver extends SmartSolver<Maze> {


    @Override
    protected @NonNull Converter<Maze> getConverter() {
        return l -> l.stream().collect(getMazeCollector());
    }


    @Override
    protected @NonNull Object doSolve(@NonNull Maze maze) {
        return KeyCollector.collectAll(maze);
    }

    protected abstract Collector<String,?,Maze> getMazeCollector();

}
