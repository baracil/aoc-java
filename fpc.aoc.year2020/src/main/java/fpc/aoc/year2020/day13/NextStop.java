package fpc.aoc.year2020.day13;

import lombok.Value;

import java.math.BigInteger;

@Value
public class NextStop {

  Bus bus;

  BigInteger waitingTime;

  public BigInteger busId() {
    return bus.id();
  }
}
