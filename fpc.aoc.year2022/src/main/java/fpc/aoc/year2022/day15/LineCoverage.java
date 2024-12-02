package fpc.aoc.year2022.day15;

import fpc.aoc.common.Sets;
import lombok.Value;

import java.util.Set;

@Value
public class LineCoverage {

  Set<Integer> beacons;
  int lineIndex;
  int inf;
  int sup;

  public int nbNotDetected() {
    return sup - inf + 1 - beacons.size();
  }

  public boolean doesNotFullyCover(int inf, int sup) {
    return this.inf > inf || this.sup < sup;
  }

  public LineCoverage merge(LineCoverage other) {
    assert other.lineIndex == this.lineIndex;
    if (this.sup < other.inf - 1 || this.inf - 1 > other.sup) {
      return null;
    }
    return new LineCoverage(
        Sets.union(beacons, other.beacons),
        lineIndex,
        Math.min(inf, other.inf),
        Math.max(sup, other.sup)
    );
  }
}
