package fpc.aoc.year2021.day6.struct;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collector;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class School {

  public static final int NB_GENERATIONS = 9;

  private final BigInteger[] census;


  public BigInteger compute_population(BigInteger[] magic_factors) {
    BigInteger result = BigInteger.ZERO;
    for (int i = 0; i < NB_GENERATIONS; i++) {
      result = result.add(census[i].multiply(magic_factors[i]));
    }
    return result;
  }

  public static School parse(String line) {
    return Arrays.stream(line.split(","))
        .map(Integer::parseInt)
        .collect(Collector.of(SchoolCollector::new, SchoolCollector::addFish,
            SchoolCollector::mergePopulation, SchoolCollector::buildSchool));
  }

  private static class SchoolCollector {
    BigInteger[] census = new BigInteger[NB_GENERATIONS];

    public SchoolCollector() {
      Arrays.fill(census, BigInteger.ZERO);
    }

    public void addFish(int timer) {
      census[timer] = census[timer].add(BigInteger.ONE);
    }

    public SchoolCollector mergePopulation(SchoolCollector c2) {

      for (int i = 0; i < NB_GENERATIONS; i++) {
        this.census[i] = this.census[i].add(c2.census[i]);
      }
      return this;
    }

    public School buildSchool() {
      return new School(census);
    }


  }

}
