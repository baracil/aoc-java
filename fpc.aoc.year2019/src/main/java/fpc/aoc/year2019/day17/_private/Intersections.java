package fpc.aoc.year2019.day17._private;

import fpc.aoc.common.Position;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Intersections {


  @NonNull
  public static Intersections findOnPicture(@NonNull Picture picture) {
    final var intersections = picture.allScaffoldPositions()
        .filter(p -> picture.scaffoldNextTo(p).count() == 4)
        .toList();
    return new Intersections(intersections);
  }

  @NonNull
  private final List<Position> positions;

  public int sumOfAlignments() {
    return positions.stream().mapToInt(p -> p.y() * p.x()).sum();
  }

}
