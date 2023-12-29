package fpc.aoc.year2020.day24.structures;

import fpc.aoc.common.AOCException;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;

import java.util.List;

@RequiredArgsConstructor
@Builder
public class Path {

  @Singular
  private final @NonNull List<Direction> steps;

  public @NonNull HexaPoint pointAtEndOfPath(@NonNull HexaPoint startingPoint) {
    final var mutable = startingPoint.toMutable();
    for (Direction step : steps) {
      mutable.move(step);
    }
    return mutable.toImmutable();
  }

  public static @NonNull Path parse(@NonNull String line) {
    final var builder = Path.builder();
    int i = 0;
    while (i < line.length()) {
      switch (line.charAt(i)) {
        case 'e' -> builder.step(Direction.E);
        case 'w' -> builder.step(Direction.W);
        case 's' -> {
          switch (line.charAt(i + 1)) {
            case 'e' -> builder.step(Direction.SE);
            case 'w' -> builder.step(Direction.SW);
            default -> throw new AOCException("Cannot parse line '" + line + "' at " + i);
          }
          ++i;
        }
        case 'n' -> {
          switch (line.charAt(i + 1)) {
            case 'e' -> builder.step(Direction.NE);
            case 'w' -> builder.step(Direction.NW);
            default -> throw new AOCException("Cannot parse line '" + line + "' at " + i);
          }
          ++i;
        }
        default -> throw new AOCException("Cannot parse line '" + line + "' at " + i);
      }
      ++i;
    }
    return builder.build();
  }
}
