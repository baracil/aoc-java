package fpc.aoc.common;

import com.google.common.collect.ImmutableSet;
import lombok.NonNull;

public class Pattern {

    private final @NonNull ImmutableSet<Displacement> positionsOfSharp;

    public Pattern(@NonNull String pattern, char withData) {
        final ImmutableSet.Builder<Displacement> positions = ImmutableSet.builder();
        final String[] lines = pattern.split("\n");
        for (int y = 0; y < lines.length; y++) {
            final var line = lines[y];
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == withData) {
                    positions.add(Displacement.of(x, y));
                }
            }
        }
        this.positionsOfSharp = positions.build();
    }

    public int nbPoints() {
        return positionsOfSharp.size();
    }

    public boolean matchAt(@NonNull ArrayOfChar searchedRegion, char expectedChar, @NonNull Position origin) {
        return positionsOfSharp.stream()
                               .map(origin::displaced)
                               .allMatch(p -> searchedRegion.get(p) == expectedChar);
    }

    public long numberOfMatches(@NonNull ArrayOfChar searchedRegion, char expectedChar) {
        return searchedRegion.positionStream()
                             .filter(p -> matchAt(searchedRegion, expectedChar, p))
                             .count();
    }
}
