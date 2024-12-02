package fpc.aoc.year2021.day9;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Map {

  private final int[] heights;
  private final int nbColumns;
  private final int nbRows;

  public int computePart1Result() {
    return lowPointPositions()
        .map(this::computeRisk)
        .sum();
  }

  public int computePart2Result() {
    final int[] buffer = heights.clone();
    final int[] lowPoints = lowPointPositions().toArray();
    final List<Integer> basinSizes = new ArrayList<>(lowPoints.length);

    for (int lowPoint : lowPoints) {
      final var size = computeBasinSize(lowPoint, buffer);
      basinSizes.add(-size);
    }

    return basinSizes.stream().sorted().limit(3)
        .reduce(-1, (s1, s2) -> s1 * s2);
  }

  private int computeBasinSize(int lowPoint, int[] buffer) {
    if (buffer[lowPoint] == 9) {
      return 0;
    }

    buffer[lowPoint] = 9;
    return 1 + computeBasinSize(lowPoint - 1, buffer)
        + computeBasinSize(lowPoint + 1, buffer)
        + computeBasinSize(lowPoint + nbColumns, buffer)
        + computeBasinSize(lowPoint - nbColumns, buffer);
  }


  private IntStream lowPointPositions() {
    return IntStream.range(0, heights.length)
        .filter(this::isLowPoint);
  }

  private int computeRisk(int pos) {
    return 1 + heights[pos];
  }

  private boolean isLowPoint(int pos) {
    final int height = heights[pos];
    if (height == 9) {
      return false;
    }

    final boolean low = height < heights[pos - 1]
        && height < heights[pos + 1]
        && height < heights[pos + nbColumns]
        && height < heights[pos - nbColumns];
    return low;
  }


  public static Map parse(List<String> lines) {
    final var nbRows = lines.size() + 2;
    final var nbColumns = lines.getFirst().length() + 2;

    final var heights = new int[nbRows * nbColumns];
    Arrays.fill(heights, 9);

    for (int i = 0, x = nbColumns + 1; i < lines.size(); i++, x += nbColumns) {
      final var line = lines.get(i);
      for (int j = 0; j < line.length(); j++) {
        heights[x + j] = line.charAt(j) - '0';
      }
    }

    return new Map(heights, nbColumns, nbRows);
  }

}
