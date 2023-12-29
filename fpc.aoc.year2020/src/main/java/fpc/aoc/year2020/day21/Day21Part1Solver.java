package fpc.aoc.year2020.day21;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day21.structures.Guide;
import lombok.NonNull;

public class Day21Part1Solver extends Day21Solver<Integer> {

    public static @NonNull Solver provider() {
        return new Day21Part1Solver();
    }

    @Override
    public @NonNull Integer doSolve(@NonNull Guide guide) {

        return guide.safeIngredients()
             .stream()
             .mapToInt(i -> guide.bagOfIngredients().quantity(i))
             .sum();

    }
}
