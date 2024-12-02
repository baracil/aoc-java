package fpc.aoc.year2019.day3;

import fpc.aoc.api.Solver;
import fpc.aoc.common.AOCException;

public class Day3Part1Solver extends BaseDay3Solver {


    public static Solver provider() {
        return new Day3Part1Solver();
    }

    @Override
    protected int compute(Path path1, Path path2) {
        return Path.intersectionStream(path1,path2)
                   .mapToInt(Point::distanceToCentralPort)
                   .min()
                   .orElseThrow(() -> new AOCException("No point of intersection found"));
    }
}
