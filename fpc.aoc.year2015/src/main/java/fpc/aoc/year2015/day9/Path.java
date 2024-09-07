package fpc.aoc.year2015.day9;

import lombok.Value;

@Value
public class Path {
  String start;
  String end;
  int length;

  public static Path parse(String line) {
    final var split = line.split(" ");
    return new Path(split[0],split[2],Integer.parseInt(split[4]));
  }

  public Path invert() {
    return new Path(end,start,length);
  }
}
