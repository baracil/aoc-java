package fpc.aoc.api;

import lombok.NonNull;
import lombok.Value;

@Value
public class AOCProblemId implements Comparable<AOCProblemId> {

    @NonNull Day day;

    @NonNull Part part;

    @Override
    public int compareTo(AOCProblemId o) {
        int result = this.day.compareTo(o.day);
        if (result == 0) {
            result = this.part.compareTo(o.part);
        }
        return result;
    }
}
