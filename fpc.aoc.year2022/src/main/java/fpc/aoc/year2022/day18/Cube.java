package fpc.aoc.year2022.day18;

import lombok.NonNull;

import java.util.stream.Stream;

public record Cube(int x, int y, int z) {

  public @NonNull Stream<Face> faces() {
    final var ref = new Point(x,y,z);
    return Disp.allValues()
        .map(ref::add)
        .map(pos -> new Face(this,pos));
  }

  public static Cube parse(@NonNull String line) {
    final var tokens = line.split(",");
    return new Cube(
        2 * Integer.parseInt(tokens[0]),
        2 * Integer.parseInt(tokens[1]),
        2 * Integer.parseInt(tokens[2])
    );
  }
}
