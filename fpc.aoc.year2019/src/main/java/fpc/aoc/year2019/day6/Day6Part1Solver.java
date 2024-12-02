package fpc.aoc.year2019.day6;

import fpc.aoc.api.Solver;

public class Day6Part1Solver extends Day6Solver {

    public static Solver provider() {
        return new Day6Part1Solver();
    }


    @Override
    protected int solve(OrbitMap map) {
        final OrbitCounter orbitCounter = new OrbitCounter();
        map.depthFirstWalk(orbitCounter);
        return orbitCounter.sumOfDirectAndIndirectOrbits();
    }
}
