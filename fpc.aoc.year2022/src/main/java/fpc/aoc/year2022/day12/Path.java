package fpc.aoc.year2022.day12;

import fpc.aoc.common.Position;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Path {
  private final Position position;
  private final int nbSteps;

  public Path withNewStep(Position position) {
    return new Path(position,nbSteps+1);
  }
}
