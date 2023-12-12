package fpc.aoc.day12;

import fpc.aoc.common.Tools;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Row {

  private final String line;
  private final int[] groupSizes;


  public static Row parse(String line) {
    final var tokens = line.split(" +");
    final var groupSizes = Tools.toArrayOfInt(tokens[1], ",");
    return new Row(tokens[0], groupSizes);
  }

  public Row unfold() {
    final var repeat = (line + "?").repeat(5);
    final var newGroups = new int[groupSizes.length*5];
    for (int i = 0; i<newGroups.length;i+=groupSizes.length) {
      System.arraycopy(groupSizes,0,newGroups,i,groupSizes.length);
    }

    final var substring = repeat.substring(0, repeat.length() - 1);
    return new Row(substring, newGroups);
  }

  @Override
  public String toString() {
    return line;
  }
}
