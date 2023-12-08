package fpc.aoc.day7.model;

public class TypeEvaluator {


  public Type evaluate(int[] cards) {
    int nbJokers = 0;
    int max = 0;
    int maxIdx = 0;
    final int[] counts = new int[13];
    for (int card : cards) {
      if (card < 0) {
        nbJokers++;
      } else {
        final var c = counts[card] + 1;
        if (c > max) {
          max = c;
          maxIdx = card;
        }
        counts[card] = c;
      }

    }
    counts[maxIdx] += nbJokers;

    final var distribution = computeDistribution(counts);
    return distribToType(distribution);
  }


  private static int[] computeDistribution(int[] counts) {
    final int[] distribution = new int[6];
    for (int count : counts) {
      distribution[count]++;
    }
    return distribution;
  }

  private Type distribToType(int[] distribution) {
    if (distribution[5] == 1) {
      return Type.FIVE_OF_A_KIND;
    }
    if (distribution[4] == 1) {
      return Type.FOUR_OF_A_KIND;
    }
    if (distribution[3] == 1 && distribution[2] == 1) {
      return Type.FULL_HOUSE;
    }
    if (distribution[3] == 1) {
      return Type.THREE_OF_A_KIND;
    }
    if (distribution[2] == 2) {
      return Type.TWO_PAIR;
    }
    if (distribution[2] == 1) {
      return Type.ONE_PAIR;
    }

    return Type.HIGH_CARD;
  }
}
