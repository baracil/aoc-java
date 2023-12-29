package fpc.aoc.year2021.day15.struct;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Map {

  public static final int SENTINEL = -1;

  private final int nbCols;
  private final int nbRows;
  private final int[] risks;

  public int startPosition() {
    return nbCols + 1;
  }

  public int nbElements() {
    return risks.length;
  }

  public int endPosition() {
    return nbCols * (nbRows - 1) - 2;
  }

  public int riskAt(int position) {
    return risks[position];
  }

  public @NonNull IntStream neighbors(int position) {
    return IntStream.of(position - 1, position + 1, position - nbCols, position + nbCols)
        .filter(i -> risks[i] != SENTINEL);
  }


  public static Map parse(@NonNull List<String> lines, int repetition) {
    final var nbRows = lines.size();
    final var nbCols = lines.get(0).length();

    final var nbMapRows = nbRows * repetition + 2;
    final var nbMapCols = nbCols * repetition + 2;


    final var risks = new int[nbMapCols * nbMapRows];
    Arrays.fill(risks, SENTINEL);

    for (int i = 0; i < repetition; i++) {
      for (int j = 0; j < repetition; j++) {
        for (int r = 0; r < lines.size(); r++) {
          final var line = lines.get(r);
          for (int c = 0; c < line.length(); c++) {
            final var idx = (1 + r + i * nbRows) * nbMapCols + (1 + c + j * nbCols);
            final var risk = line.charAt(c) - '0';
            risks[idx] = ((risk - 1 + i + j) % 9) + 1;
          }
        }
      }
    }

    return new Map(nbMapCols, nbMapRows, risks);
  }

}
