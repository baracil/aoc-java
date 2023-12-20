package fpc.aoc.day20;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;
import lombok.NonNull;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Day20Part2Solver extends Day20Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day20Part2Solver().createProblem();
    }


    @Override
    public @NonNull Long solve(@NonNull Circuit circuit) {

        final var seen = new HashSet<Map<String, FlipFlopState>>();

        var state = circuit.initialState();

        DotDumper.dump(circuit,state,"day20_0.dot");

        state = circuit.execute(state).state();

        DotDumper.dump(circuit,state,"day20_1.dot");


        throw new NotSolvedYet();
    }
}
