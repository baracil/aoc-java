package fpc.aoc.year2019.day14;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2019.day14.computation.ChemicalBook;

public abstract class Day14Solver extends SmartSolver<ChemicalBook> {

    @Override
    protected Converter<ChemicalBook> getConverter() {
        return list -> list.stream().collect(ChemicalBook.collector());
    }

}
