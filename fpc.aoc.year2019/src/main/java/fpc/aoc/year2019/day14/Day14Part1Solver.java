package fpc.aoc.year2019.day14;

import fpc.aoc.api.Solver;
import fpc.aoc.year2019.day14.computation.ChemicalBook;
import fpc.aoc.year2019.day14.computation.ReversedFactory;

public class Day14Part1Solver extends Day14Solver {

    public static Solver provider() {
        return new Day14Part1Solver();
    }


    @Override
    protected Long doSolve(ChemicalBook chemicalBook) {
        final ReversedFactory reversedFactory = new ReversedFactory(chemicalBook);

        reversedFactory.clear();
        reversedFactory.produce(chemicalBook.fuel(), 1L);

        return reversedFactory.requiredOre();
    }
}
