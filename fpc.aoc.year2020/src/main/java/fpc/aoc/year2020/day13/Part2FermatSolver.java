package fpc.aoc.year2020.day13;

import fpc.aoc.common.Tools;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.IntStream;

public class Part2FermatSolver implements Part2Solver {

  public BigInteger doSolve(List<Bus> buses) {

    //assume all numbers are primes
    final var product = buses.stream()
        .filter(Bus::isRunning)
        .map(Bus::id)
        .reduce(BigInteger.ONE, BigInteger::multiply);

    // Let consider the number of the form
    //
    // N = k_1.(product/id_1) + k_2.(product/id_2) + k_3.(product/id_3) + ...
    //
    // where 'product' is the product of all the id_i and k_i are some values
    // we can adjust
    //
    // then r_i the modulo of N by id_i is :
    //
    // r_i = N mod id_i = ki.(product/id_i)   (since 'product' is a multiple of all the other id)
    //
    // This does not depend on the other k.
    // by finding the ki such as r_i = i, N will be a solution to the problem.
    // then by taking the modulo of this solution by the 'product' we will get the
    // minimal solution
    //
    // each equationm r_i can be solved independently from each other by using Ferma's little theorem

    return IntStream.range(0, buses.size())
        .mapToObj(i -> solveForOneBus(buses.get(i), product, i))
        .reduce(BigInteger.ZERO, BigInteger::add)
        .mod(product);
  }

  //we use the Fermat's little theorem
  public BigInteger solveForOneBus(Bus bus, BigInteger productOfAllIds, int index) {
    if (bus.isOutOfService()) {
      return BigInteger.ZERO;
    }
    final var id = bus.id();
    final var remaining = BigInteger.valueOf(Tools.mod(id.intValue() - index, id.intValue()));

    if (remaining.equals(BigInteger.ZERO)) {
      return BigInteger.ZERO;
    }

    final var productOfOthers = productOfAllIds.divide(id);
    //Fermat's little theorem says that : productOfOthers^(id-1) = 1 [id] (we assume all ids are prime)
    return productOfOthers.pow(id.intValue() - 1).multiply(remaining);
  }

}
