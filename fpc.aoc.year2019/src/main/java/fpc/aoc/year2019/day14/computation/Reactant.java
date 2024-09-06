package fpc.aoc.year2019.day14.computation;

import lombok.NonNull;
import lombok.Value;

@Value
public class Reactant {

    @NonNull Chemical chemical;

    int amount;

    @Override
    public String toString() {
        return String.format("%d %s",amount,chemical);
    }
}
