package fpc.aoc.year2019.day6;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day6Part2Solver extends Day6Solver {

    public static Solver provider() {
        return new Day6Part2Solver();
    }


    @Override
    protected int solve(@NonNull OrbitMap map) {
        final OrbitPath pathToYou = map.pathFromRoot("YOU");
        final OrbitPath pathToSanta = map.pathFromRoot("SAN");

        final String lastCommon = OrbitPath.lastCommonBody(pathToSanta,pathToYou);
        final int distance = map.distanceFromRoot(lastCommon);

        return pathToSanta.size()+pathToYou.size() - 2*distance - 4;
    }
}
