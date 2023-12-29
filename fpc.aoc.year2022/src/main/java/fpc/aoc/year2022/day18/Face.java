package fpc.aoc.year2022.day18;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(of = {"center"})
public class Face {

  Cube cube;
  Point center;

  @Override
  public String toString() {
    return "Face{" + center + '}';
  }
}
