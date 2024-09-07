package fpc.aoc.year2019.day21._private;

import lombok.NonNull;

/**
 * @author Bastien Aracil
 **/
public interface TruthTable {

    int nbParameters();

    @NonNull
    TriBool value(int parameters);
}
