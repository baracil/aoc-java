package fpc.aoc.year2020.day16;

import lombok.NonNull;
import lombok.Value;

@Value
public class IntRange {
    int lower;
    int upper;

    public boolean isInRange(int value) {
        return lower<=value && value <= upper;
    }

    public void setValidityFlag(boolean[] input) {
        for (int i = lower, max=input.length; i<=upper && i<max;i++) {
            input[i] = true;
        }
    }

    public static @NonNull IntRange parse(@NonNull String lower, @NonNull String upper) {
        return new IntRange(Integer.parseInt(lower), Integer.parseInt(upper));
    }
}
