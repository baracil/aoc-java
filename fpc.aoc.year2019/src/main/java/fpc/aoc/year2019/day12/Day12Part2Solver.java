package fpc.aoc.year2019.day12;

import fpc.aoc.common.AOCException;
import fpc.aoc.year2019.day12.computation.MoonSystem;
import fpc.aoc.year2019.day12.computation.PeriodFinder;
import fpc.aoc.year2019.day12.computation.TimeOfDuplicates;
import fpc.aoc.year2019.day12.computation.Vector;
import lombok.NonNull;

import java.math.BigInteger;

public class Day12Part2Solver extends Day12Solver {

  @Override
  protected @NonNull Object doSolve(@NonNull MoonSystem moonSystem) {
    final TimeOfDuplicates x = PeriodFinder.findPeriod(moonSystem, Vector::x);
    final TimeOfDuplicates y = PeriodFinder.findPeriod(moonSystem, Vector::y);
    final TimeOfDuplicates z = PeriodFinder.findPeriod(moonSystem, Vector::z);

    if (x.first() != 0 || y.first() != 0 || z.first() != 0) {
      throw new AOCException("Cannot handle this situation");
    }

    final BigInteger p1 = BigInteger.valueOf(x.second());
    final BigInteger p2 = BigInteger.valueOf(y.second());
    final BigInteger p3 = BigInteger.valueOf(z.second());

    return lcm(p1, lcm(p2, p3)).toString();
  }

  private BigInteger lcm(BigInteger n1, BigInteger n2) {
    return n1.divide(n1.gcd(n2)).multiply(n2);
  }

}
