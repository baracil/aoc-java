package fpc.aoc.year2019.day21;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.List;
import java.util.function.Function;

public class Day21Part2Solver extends Day21Solver {

    public static Solver provider() {
        return new Day21Part2Solver();
    }

    @Override
    int solve(@NonNull Function<List<String>,Result> executor) {
        final Result result = executor.apply(getLogicalProgram());
        return result.damage();
    }

    private List<String> getLogicalProgram() {
        return List.of(
          "NOT G T",
          "AND H T",
          "OR E T",
          "NOT F J",
          "OR J T",

          "NOT C J",
          "AND J T",
          "NOT B J",
          "OR J T",

          "AND D T",
          "NOT A J",

          "OR T J"
        );
    }

    @Override
    int sensorRange() {
        return 9;
    }

    @Override
    String launchCommand() {
        return "RUN";
    }
}
