package fpc.aoc.year2019.day10;

import fpc.aoc.api.Solver;
import fpc.aoc.year2019.day10.computation.AsteroidField;
import fpc.aoc.year2019.day10.computation.Base;
import lombok.NonNull;

/**
 * @author Bastien Aracil
 **/
public class Day10Part1Solver extends Day10Solver {

    public static Solver provider() {
        return new Day10Part1Solver();
    }


    @Override
    protected @NonNull Object doSolve(@NonNull AsteroidField asteroidField) {
        final Base base = asteroidField.findOptimalBase();
        return base.numberOfVisibleAsteroids();
    }
}
