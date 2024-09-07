package fpc.aoc.year2019.day24;

import fpc.aoc.api.Solver;
import fpc.aoc.year2019.day24._private.BugColony;
import fpc.aoc.year2019.day24._private.Position;
import fpc.aoc.year2019.day24._private.part1.Nature;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Bastien Aracil
 **/
public class Day24Part1Solver extends Day24Solver {

    public static Solver provider() {
        return new Day24Part1Solver();
    }


    @Override
    protected Object doSolve(@NonNull BugColony colony) {
        final Nature nature = Nature.create();
        final Set<Integer> seens = new HashSet<>();
        int current = colony.bugPositionsStream().mapToInt(this::positionToPower).reduce(0, Day24Part1Solver::or);
        do {
            if (!seens.add(current)) {
                return current;
            }
            current = nature.evolve(current);
        } while (true);

    }

    private int positionToPower(@NonNull Position position) {
        return 1<<(position.x()+5*position.y());
    }

    private static int or(int v1, int v2) {
        return v1|v2;
    }
}
