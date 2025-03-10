package fpc.aoc.year2019.day7;

import fpc.aoc.common.NumericalStrings;
import fpc.aoc.common.Permutation;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.ProgramBasedSolver;

public abstract class Day7Solver extends ProgramBasedSolver {


    @Override
    protected Object doSolve(Program program) {
        final Circuit circuit = createCircuit(program);
        final Permutation<Phase> phases = Permutation.create(phaseValues(),Phase::new);

        return phases.stream().map(circuit::launch)
            .max(NumericalStrings::compare)
            .orElseThrow();
    }

    protected abstract Circuit createCircuit(Program program);

    protected abstract String[] phaseValues();

}
