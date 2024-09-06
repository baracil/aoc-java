package fpc.aoc.year2019.day14;

import fpc.aoc.api.Solver;
import fpc.aoc.year2019.day14.computation.ChemicalBook;
import fpc.aoc.year2019.day14.computation.ReversedFactory;
import lombok.NonNull;

import java.util.function.LongUnaryOperator;

public class Day14Part2Solver extends Day14Solver {

  public static Solver provider() {
    return new Day14Part2Solver();
  }

  @Override
  protected @NonNull Object doSolve(@NonNull ChemicalBook chemicalBook) {
    final long available = 1_000_000_000_000L;


    return findMaxProduction(available, rf -> computeOreRequirement(chemicalBook, rf));
  }

  private long findMaxProduction(long available, @NonNull LongUnaryOperator operator) {
    final long for1 = operator.applyAsLong(1);

    long inputLow = available / for1;
    long outputLow = operator.applyAsLong(inputLow);

    long inputHigh = inputLow;
    long outputHigh = outputLow;

    while (outputHigh < available) {
      inputHigh += inputLow;
      outputHigh = operator.applyAsLong(inputHigh);
    }

    do {
      long inputMiddle = Math.round(inputLow + (inputHigh - inputLow) * (available - outputLow) / (outputHigh - outputLow + 0.0));
      if (inputMiddle <= inputLow) {
        inputMiddle = inputLow + 1;
      } else if (inputMiddle >= inputHigh) {
        inputMiddle = inputHigh - 1;
      }

      long outputMiddle = operator.applyAsLong(inputMiddle);

      if (outputMiddle == available) {
        return outputMiddle;
      } else if (outputMiddle < available) {
        inputLow = inputMiddle;
        outputLow = outputMiddle;
      } else {
        inputHigh = inputMiddle;
        outputHigh = outputMiddle;
      }
    } while ((inputHigh - inputLow) > 1);
    return inputLow;
  }

  private long computeOreRequirement(@NonNull ChemicalBook chemicalBook, long requiredFuel) {
    final var reversedFactory = new ReversedFactory(chemicalBook);
    reversedFactory.clear();
    reversedFactory.produce(chemicalBook.fuel(), requiredFuel);
    return reversedFactory.requiredOre();
  }
}
