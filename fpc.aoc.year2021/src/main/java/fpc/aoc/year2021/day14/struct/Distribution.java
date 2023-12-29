package fpc.aoc.year2021.day14.struct;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public class Distribution {
    private final @NonNull Couple couple;
    private final @NonNull long[] counts;


    public long getAmplitude() {
        final var statistics = Arrays.stream(counts).filter(i -> i > 0).summaryStatistics();
        return statistics.getMax() - statistics.getMin();
    }

    public @NonNull Distribution add(@NonNull Distribution right) {
        final var merged = this.couple.merge(right.couple);

        final var counts = this.counts.clone();
        for (int i = 0; i < counts.length; i++) {
            counts[i] += right.counts[i];
        }
        counts[this.couple.rightIndex()] -= 1;

        return new Distribution(merged,counts);
    }

    public static @NonNull Distribution singleCouple(@NonNull Couple couple) {
        final var counts = new long[26];

        counts[couple.leftIndex()] +=1;
        counts[couple.rightIndex()] +=1;

        return new Distribution(couple,counts);
    }

}
