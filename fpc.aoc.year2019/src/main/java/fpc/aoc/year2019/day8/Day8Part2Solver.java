package fpc.aoc.year2019.day8;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

public class Day8Part2Solver extends Day8Solver {

    public static Solver provider() {
        return new Day8Part2Solver();
    }


    @Override
    protected String solve(@NonNull List<Layer> layers) {
        return layers.stream()
              .reduce(Layer::stack)
              .orElseThrow()
              .lines()
              .collect(Collectors.joining("\n","\n",""));
    }

}
