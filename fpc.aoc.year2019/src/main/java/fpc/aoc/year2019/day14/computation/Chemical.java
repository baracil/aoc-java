package fpc.aoc.year2019.day14.computation;

import lombok.NonNull;
import lombok.Value;

@Value
public class Chemical implements Comparable<Chemical> {

    @NonNull String name;

    int complexity;

    @Override
    public String toString() {
        return String.format("%s (%d)",name,complexity);
    }

    public boolean isOre() {
        return name.equals("ORE");
    }

    @Override
    public int compareTo(Chemical o) {
        int result = this.complexity - o.complexity;
        if (result == 0) {
            result = this.name.compareTo(o.name);
        }
        return result;
    }
}
