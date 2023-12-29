package fpc.aoc.year2022.day6;

import lombok.Getter;

import java.util.Arrays;

public class MarkerFinder {

  private final int dataMarkerLength;
  private final int[] current;
  private final int[] counts;
  @Getter
  private int idx;
  private int nbDistinct;
  @Getter
  private boolean found = false;

  public MarkerFinder(int dataMarkerLength) {
    this.dataMarkerLength = dataMarkerLength;
    this.current = new int[dataMarkerLength];
    this.counts = new int[26];
    Arrays.fill(this.current, -1);
  }

  public void handleChar(char c) {
    final int countIndexToIncrease = c - 'a';
    final int countIndexToDecrease = this.current[idx % dataMarkerLength];
    this.current[idx % dataMarkerLength] = countIndexToIncrease;

    idx++;

    if (countIndexToDecrease != countIndexToIncrease) {
      updateCount(countIndexToDecrease, -1);
      updateCount(countIndexToIncrease, +1);
    }

    found = nbDistinct == dataMarkerLength;
  }


  private void updateCount(int countIndex, int delta) {
    if (countIndex < 0) {
      return;
    }
    final var oldCount = this.counts[countIndex];
    final var newCount = oldCount + delta;
    this.counts[countIndex] = newCount;
    this.handleModification(oldCount, newCount);
  }

  private void handleModification(int oldCount, int newCount) {
    if (oldCount == 1) {
      nbDistinct--;
    }
    if (newCount == 1) {
      nbDistinct++;
    }
  }
}
