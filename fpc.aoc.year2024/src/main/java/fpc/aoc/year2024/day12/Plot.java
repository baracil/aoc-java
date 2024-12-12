package fpc.aoc.year2024.day12;

import fpc.aoc.common.Displacement;
import fpc.aoc.common.Orientation;
import fpc.aoc.common.Position;
import fpc.aoc.common.Translation;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.function.Predicate.not;

@RequiredArgsConstructor
public class Plot {

  private final Set<Position> positions;
  private int perimeter = -1;
  private int nbSides = -1;

  public int area() {
    return positions.size();
  }

  public int perimeter() {
    if (perimeter <= 0) {
      perimeter = positions.stream().mapToInt(p -> 4 - nbNeighbours(p)).sum();
    }
    return perimeter;
  }

  public int nbSides() {
    if (nbSides <= 0) {
      final var border = findOuterBorders();
      nbSides = border.stream().mapToInt(this::cornerCount).sum();
    }
    return nbSides;
  }

  private Set<Position> findOuterBorders() {
    final var outerBorders = new HashSet<Position>();
    for (Position position : positions) {
      Arrays.stream(BORDERS)
          .map(position::displaced)
          .filter(not(this.positions::contains))
          .forEach(outerBorders::add);
    }
    return outerBorders;
  }

  private static final Translation[] BORDERS = {
      Displacement.NW,Displacement.N,Displacement.NE,
      Displacement.W,Displacement.E,
      Displacement.SW,Displacement.S,Displacement.SE,
  };
  private static final int[] MASKS = {
      0b100_000_000, 0b010_000_000,0b001_000_000,
      0b000_100_000, 0b000_001_000,
      0b000_000_100, 0b000_000_010,0b000_000_001,
  };

  private static final int N = 0b010_000_000;
  private static final int E = 0b000_001_000;
  private static final int S = 0b000_000_010;
  private static final int W = 0b000_100_000;
  private static final int NW_CORNER = 0b100_000_000;
  private static final int NE_CORNER = 0b001_000_000;
  private static final int SE_CORNER = 0b000_000_001;
  private static final int SW_CORNER = 0b000_000_100;

  private static final int NW_MASK = N|W|NW_CORNER;
  private static final int NE_MASK = N|E|NE_CORNER;
  private static final int SE_MASK = S|E|SE_CORNER;
  private static final int SW_MASK = S|W|SW_CORNER;

  private int cornerCount(Position position) {
    int val = 0;
    for (int i = 0; i < BORDERS.length; i++) {
      if (positions.contains(position.displaced(BORDERS[i]))) {
        val |= MASKS[i];
      }
    }
    int count = 0;
    final var nw = val & NW_MASK;
    if (nw == NW_CORNER || nw == (N|W) || nw == NW_MASK) {
      count++;
    }
    final var ne = val & NE_MASK;
    if (ne == NE_CORNER || ne == (N|E) || ne == NE_MASK) {
      count++;
    }
    final var se = val & SE_MASK;
    if (se == SE_CORNER || se == (S|E) || se == SE_MASK) {
      count++;
    }
    final var sw = val & SW_MASK;
    if (sw == SW_CORNER || sw == (S|W) || sw == SW_MASK) {
      count++;
    }

    return count;
  }



  private int nbNeighbours(Position position) {
    return (int) Arrays.stream(Orientation.values())
        .map(position::displaced)
        .filter(this.positions::contains)
        .count();
  }

}
