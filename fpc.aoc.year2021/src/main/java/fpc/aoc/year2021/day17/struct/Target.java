package fpc.aoc.year2021.day17.struct;

import lombok.NonNull;

import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Target(int xmin, int xmax, int ymin, int ymax) {

  public static final Pattern PATTERN = Pattern.compile("target area: x=(?<xmin>-?\\d+)..(?<xmax>-?\\d+), y=(?<ymin>-?\\d+)..(?<ymax>-?\\d+)");

  public static @NonNull Target parse(@NonNull String line) {
    final var matcher = PATTERN.matcher(line);
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Cannot match " + line);
    }

    final var xmin = Integer.parseInt(matcher.group("xmin"));
    final var xmax = Integer.parseInt(matcher.group("xmax"));
    final var ymin = Integer.parseInt(matcher.group("ymin"));
    final var ymax = Integer.parseInt(matcher.group("ymax"));

    return new Target(xmin, xmax, ymin, ymax);
  }

  public @NonNull Stream<Vec> searchSpace() {
    return IntStream.rangeClosed(1, this.xmax)
        .mapToObj(x -> IntStream.rangeClosed(this.ymin - 1, -this.ymin).mapToObj(y -> new Vec(x, y)))
        .flatMap(s -> s);
  }
}
