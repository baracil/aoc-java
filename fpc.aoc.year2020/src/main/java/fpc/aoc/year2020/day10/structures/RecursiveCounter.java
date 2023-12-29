package fpc.aoc.year2020.day10.structures;

import lombok.NonNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RecursiveCounter implements Part2Counter {

    @Override
    public long count(@NonNull int[] input) {
        return new Execution(input).countArrangements();
    }

    private static class Execution {

        private final int[] sortedPlug;

        private final Map<Integer, Long> cache = new HashMap<>();

        public Execution(int[] input) {
            this.sortedPlug = input.clone();
            Arrays.sort(sortedPlug);
        }

        public long countArrangements() {
            return countArrangements(0, 0);
        }

        private long countArrangements(int reference, int fromIndex) {
            final Long cached = cache.get(fromIndex);
            if (cached == null) {
                return countArrangementsWithoutCache(reference, fromIndex);
            } else {
                return cached;
            }
        }

        private long countArrangementsWithoutCache(int reference, int fromIndex) {
            if (thisIsTheLastPlug(fromIndex)) {
                return 1;
            }
            long count = 0;
            for (int j = fromIndex; j < sortedPlug.length; j++) {
                final int jolt = sortedPlug[j];
                final int dif = jolt - reference;
                if (dif > 3) {
                    break;
                }
                count += countArrangements(sortedPlug[j], j + 1);
            }
            cache.put(fromIndex, count);
            return count;
        }

        private boolean thisIsTheLastPlug(int index) {
            return index == sortedPlug.length;
        }

    }
}
