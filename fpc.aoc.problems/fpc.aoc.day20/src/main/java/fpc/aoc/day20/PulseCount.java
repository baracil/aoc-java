package fpc.aoc.day20;

public record PulseCount(long nbLow, long nbHigh) {

  public PulseCount add(PulseCount other) {
    return new PulseCount(this.nbLow+other.nbLow, this.nbHigh + other.nbHigh);
  }
}
