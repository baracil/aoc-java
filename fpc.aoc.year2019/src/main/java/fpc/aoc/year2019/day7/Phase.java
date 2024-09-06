package fpc.aoc.year2019.day7;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Phase {

    @NonNull
    public static Phase with(String phases) {
        return new Phase(phases.split(""));
    }

    private final String[] phases;

    public String get(int index) {
        return phases[index];
    }

    public int size() {
        return phases.length;
    }

    @Override
    public String toString() {
        return "Phase{" + String.join("", phases) + "}";
   }
}
