package fpc.aoc.year2019.day24._private.part1;

import fpc.aoc.common.Tools;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * -A-A-
 * A-A-A
 * -A-A- 2^12 = 4096 : even
 * A-A-A 2^13 = 8192 : odd
 * -A-A-
 * 12| 0  1
 * 0  1         |-----
 * 1 ->  1  1       00| 0  0
 * 2 ->  1  0       01| 1  0
 * 11| x  x
 * 10| 1  1
 * <p>
 * f(i) = 1 + !1.2.!i = 1 + 2.!i
 * <p>
 * 0  .......
 * 7  .-A-A-.   8 10 12  16 18  22 24 26  30 32  36 38 40
 * 14  .A-A-A.    9 11   15 17 19  23 25  29 31 33  37 39
 * 21  .-A-A-.   2^12 = 4096 : even
 * 28  .A-A-A.   2^13 = 8192 : odd
 * 35  .-A-A-.
 * <p>
 * .  1 .
 * 7  . 9
 * . 15 .
 *
 * @author perococco
 **/
@RequiredArgsConstructor
public class MaskBuilder {

  private static final long B1 = 1L << 1;
  private static final long B7 = 1L << 7;
  private static final long B9 = 1L << 9;
  private static final long BF = 1L << 15;

  private static final Set<Long> ONE = Set.of(B1, B7, B9, BF);
  private static final Set<Long> TWO = Set.of(B1 + B7, B1 + B9, B1 + BF, B7 + B9, B7 + BF, B9 + BF);

  private static final long PATTERN_MASK = 0b11100001110000111;

  private static final int[] EVEN_POSITIONS = IntStream.range(0, 25).filter(i -> (i % 2) == 0).toArray();
  private static final int[] ODD_POSITIONS = IntStream.range(0, 25).filter(i -> (i % 2) == 1).toArray();

  /*
   *  0  .......
   *  7  .-A-A-.   8 10 12  16 18  22 24 26  30 32  36 38 40
   * 14  .A-A-A.    9 11   15 17 19  23 25  29 31 33  37 39
   * 21  .-A-A-.   2^12 = 4096 : even
   * 28  .A-A-A.   2^13 = 8192 : odd
   * 35  .-A-A-.
   */
  //0   1   2   3   4  |  5   6   7   8   9  |  10  11  12  13  14  |  15  16  17  18  19  |  20  21  22  23  24
  //8   9  10  11  12  | 15  16  17  18  19  |  22  23  24  25  26  |  29  30  31  32  33  |  36  37  38  39  40

  @NonNull
  public static SubLayout buildEven() {
    return new MaskBuilder(EVEN_POSITIONS).build();
  }

  @NonNull
  public static SubLayout buildOdd() {
    return new MaskBuilder(ODD_POSITIONS).build();
  }

  private final int[] positions;

  private final int[] borders;

  private final int[] masks;

  private final int[] borderedPositions;

  public MaskBuilder(int[] positions) {
    this.positions = positions;
    this.borders = OtherHalfPositions.with(positions);
    this.masks = IntStream.of(positions).map(i -> 1 << i).toArray();
    this.borderedPositions = IntStream.of(positions).map(SimpleToBordered.instance()).toArray();
  }

  @NonNull
  private SubLayout build() {
    final int mask = IntStream.of(positions).map(i -> 1 << i).reduce(0, (i1, i2) -> i1 | i2);
    final int borderMask = IntStream.of(borders).map(i -> 1 << i).reduce(0, (i1, i2) -> i1 | i2);

    final var cache = IntStream.range(0, 1 << borders.length).mapToObj(this::createMask)
        .collect(Tools.toMap(Masks::value));

    return new SubLayout(mask, borderMask, cache);
  }

  @NonNull
  private Masks createMask(final int bordersNumber) {
    final int borders = createLayout(bordersNumber);
    final long borderedLayout = createBorderedLayout(borders);
    int one = 0;
    int two = 0;
    for (int i = 0; i < positions.length; i++) {
      final int shift = borderedPositions[i] - 8;
      final long pattern = PATTERN_MASK & (borderedLayout >> shift);
      one = one | (ONE.contains(pattern) ? (masks[i]) : 0);
      two = two | (TWO.contains(pattern) ? (masks[i]) : 0);
    }
    return new Masks(borders, one, two);
  }

  private int createLayout(int layoutNumber) {
    return IntStream.range(0, borders.length)
        .filter(i -> isBitSet(layoutNumber, i))
        .map(i -> borders[i])
        .map(p -> 1 << p)
        .reduce(0, (i1, i2) -> i1 | i2);
  }

  private long createBorderedLayout(int layout) {
    return Arrays.stream(borders, 0, borders.length)
        .filter(p -> isBitSet(layout, p))
        .map(SimpleToBordered.instance())
        .mapToLong(i -> 1L << i)
        .reduce(0L, (i1, i2) -> i1 | i2);
  }

  private boolean isBitSet(int value, int bit) {
    return (value & (1 << bit)) != 0;
  }


}
