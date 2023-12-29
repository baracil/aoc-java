package fpc.aoc.year2022.day17;

import lombok.NonNull;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Snapshot {

  private final ShapeType shapeType;
  private final int[] levels;
  private final int jetIndex;

  private final int hashCode;

  public Snapshot(int[] levels, @NonNull ShapeType shapeType, int jetIndex) {
    this.shapeType = shapeType;
    this.levels = levels;
    this.jetIndex = jetIndex;
    this.hashCode = 31*(31*Arrays.hashCode(levels)+jetIndex)+shapeType.ordinal();
  }

  @Override
  public String toString() {
    return Arrays.stream(levels).mapToObj(Snapshot::toString).collect(Collectors.joining("|"));
  }

  private static String toString(int level) {
    return IntStream.range(0,7).map(i -> 1<<(6-i)).mapToObj(i -> (level&i) ==0 ? ".":"#").collect(Collectors.joining());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Snapshot snapshot = (Snapshot) o;
    return Arrays.equals(levels, snapshot.levels) && jetIndex == snapshot.jetIndex && shapeType == snapshot.shapeType;
  }

  @Override
  public int hashCode() {
    return hashCode;
  }
}
