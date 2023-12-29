package fpc.aoc.common;

import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;

public class Pattern {

  private final @NonNull Set<Displacement> positionsOfSharp;

  public Pattern(@NonNull String pattern, char withData) {
    final Set<Displacement> positions = new HashSet<>();
    final String[] lines = pattern.split("\n");
    for (int y = 0; y < lines.length; y++) {
      final var line = lines[y];
      for (int x = 0; x < line.length(); x++) {
        if (line.charAt(x) == withData) {
          positions.add(Displacement.of(x, y));
        }
      }
    }
    this.positionsOfSharp = positions;
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
