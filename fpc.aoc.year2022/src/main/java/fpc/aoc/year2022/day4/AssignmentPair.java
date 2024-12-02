package fpc.aoc.year2022.day4;

import fpc.aoc.common.IntRange;
import lombok.Value;

@Value
public class AssignmentPair {
  IntRange section1;
  IntRange section2;


  public static AssignmentPair parse(String line) {
    final var idx = line.indexOf(",");
    return new AssignmentPair(AssignmentPair.parseToIntRange(line.substring(0, idx)), AssignmentPair.parseToIntRange(line.substring(idx + 1)));
  }

  public boolean hasSectionFullyContainedInOther() {
    return section2.contains(section1) || section1.contains(section2);
  }

  public boolean hasSectionsOverlapping() {
    return section1.overlapsWith(section2);
  }

  private static IntRange parseToIntRange(String line) {
    final var idx = line.indexOf("-");

    final var section1 = Integer.parseInt(line.substring(0, idx));
    final var section2 = Integer.parseInt(line.substring(idx + 1));
    return new IntRange(section1, section2);
  }

}
