package fpc.aoc.year2019.day20;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.year2019.day20._private.Maze;

public class Day20Part1Solver extends Day20Solver {


    @Override
    Maze buildMaze(ArrayOfChar input) {
        return Maze.createNormal(input);
    }

}
