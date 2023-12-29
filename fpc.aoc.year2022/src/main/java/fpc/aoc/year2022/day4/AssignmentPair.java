package fpc.aoc.year2022.day4;

import fpc.aoc.common.IntRange;
import lombok.NonNull;
import lombok.Value;

@Value
public class AssignmentPair {
  @NonNull IntRange section1;
  @NonNull IntRange section2;


  public static @NonNull AssignmentPair parse(@NonNull String line) {
    final var idx = line.indexOf(",");
    return new AssignmentPair(AssignmentPair.parseToIntRange(line.substring(0,idx)), AssignmentPair.parseToIntRange(line.substring(idx+1)));
  }

  public boolean hasSectionFullyContainedInOther() {
    return section2.contains(section1) || section1.contains(section2);
  }

  public boolean hasSectionsOverlapping() {
    return section1.overlapsWith(section2);
  }

  private static IntRange parseToIntRange(@NonNull String line) {
    final var idx = line.indexOf("-");

    final var section1 = Integer.parseInt(line.substring(0, idx));
    final var section2 = Integer.parseInt(line.substring(idx + 1));
    return new IntRange(section1, section2);
  }

}
