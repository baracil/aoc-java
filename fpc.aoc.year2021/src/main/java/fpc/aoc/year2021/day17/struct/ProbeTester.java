package fpc.aoc.year2021.day17.struct;

import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public class ProbeTester {

  private final Target target;

  public boolean willReach(Vec velocity) {
    if (velocity.x() * (velocity.x() + 1) / 2 < target.xmin()) {
      return false;
    }
    return Stream.iterate(new Probe(Vec.ZERO, velocity), p -> !p.missed(target), Probe::afterOnTick)
        .anyMatch(p -> p.isInside(target));
  }
}
