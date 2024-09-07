package fpc.aoc.year2019.day24;

import fpc.aoc.api.Solver;
import fpc.aoc.year2019.day24._private.BugColony;
import lombok.NonNull;

/**
 * @author Bastien Aracil
 **/
public class Day24Part2Solver extends Day24Solver {
    public static Solver provider() {
        return new Day24Part2Solver();
    }


    @Override
    protected Object doSolve(@NonNull BugColony colony) {
        BugColony current = colony.evolve(200);
        return current.size();
    }
}
