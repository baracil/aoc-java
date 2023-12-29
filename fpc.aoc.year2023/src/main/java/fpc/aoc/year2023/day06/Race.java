package fpc.aoc.year2023.day06;

import fpc.aoc.common.Tools;
import lombok.Value;

import java.util.List;
import java.util.function.ToLongBiFunction;
import java.util.stream.IntStream;

@Value
public class Race {
  long duration;
  long bestDistance;

  //
  // (D-h)*h-B > 0 => h*h - D*h +B < 0
  // a= 1, b = -D , c=B
  // -D +/- sqrt(D*D-4B)
  //

  public long nbWins() {
    final long a = 1;
    final long b = -duration;
    final long c = bestDistance;
    final long delta = b*b-4*a*c;
    if (delta<=0) {
      return 0;
    }
    final double d = Math.sqrt(delta);
    final long first = (long)Math.ceil(0.5*(duration-d));
    final long last = (long)Math.floor(0.5*(duration+d));

    final boolean exactFirst = computeDistance(first) <= bestDistance;
    final boolean exactLast = computeDistance(last) <= bestDistance;

    return last-first+1 - (exactFirst?1:0) - (exactLast?1:0);
  }

  public long computeDistance(long heldDuration) {
    return (duration-heldDuration)*heldDuration;
  }


  public static List<Race> parsePart1(List<String> lines) {
    final var durations = Tools.toArrayOfLong(lines.get(0).substring("Time:".length()));
    final var bestDistances = Tools.toArrayOfLong(lines.get(1).substring("Distance:".length()));

    return IntStream.range(0, durations.length)
      .mapToObj(i -> new Race(durations[i], bestDistances[i])).toList();
  }

  public static Race parsePart2(List<String> lines) {

    final ToLongBiFunction<String,String> getter = (line,header) -> Long.parseLong(line.trim().substring(header.length()).trim().replace(" ",""));

    final var duration = getter.applyAsLong(lines.get(0),"Time:");
    final var bestDistance = getter.applyAsLong(lines.get(1),"Distance:");
    return new Race(duration,bestDistance);
  }
}
