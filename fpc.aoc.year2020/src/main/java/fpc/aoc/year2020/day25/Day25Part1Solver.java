package fpc.aoc.year2020.day25;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.math.BigInteger;

public class Day25Part1Solver extends Day25Solver {

  public static @NonNull Solver provider() {
    return new Day25Part1Solver();
  }

  @Override
  public @NonNull Long doSolve(@NonNull Day25Input input) {
    final PublicKeys k = new PublicKeys(20201227);
    final int doorLoopSize = k.powerOf(input.doorPublicKey());
    final int cardLoopSize = k.powerOf(input.cardPublicKey());


    final var seven = BigInteger.valueOf(7);
    final var modulo = BigInteger.valueOf(20201227);

    return BigInteger.valueOf(input.cardPublicKey()).modPow(BigInteger.valueOf(doorLoopSize), modulo).mod(modulo).longValue();

  }

  private static class PublicKeys {

    private final int[] valueToPower;

    private final int modulo;

    public PublicKeys(int modulo) {
      this.valueToPower = new int[modulo];
      this.modulo = modulo;
      int v = 1;
      for (int i = 0; i < modulo - 1; i++) {
        valueToPower[v - 1] = i;
        v = (v * 7) % modulo;
      }
    }

    public int powerOf(int v) {
      return valueToPower[(v % modulo) - 1];
    }
  }
}
