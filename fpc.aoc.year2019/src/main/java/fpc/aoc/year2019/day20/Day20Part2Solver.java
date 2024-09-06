package fpc.aoc.year2019.day20;

import fpc.aoc.api.Solver;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.year2019.day20._private.Maze;

public class Day20Part2Solver extends Day20Solver {

    public static Solver provider() {
        return new Day20Part2Solver();
    }

    @Override
    Maze buildMaze(ArrayOfChar input) {
        return Maze.createRecursive(input);
    }

}
