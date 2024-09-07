package fpc.aoc.year2015.day14;

import lombok.Value;

@Value
public class Reindeer {
  String name;
  int speed;
  int duration;
  int rest;

  public static Reindeer parse(String line) {
    final var tokens = line.split(" ");
    return new Reindeer(
      tokens[0],
      Integer.parseInt(tokens[3]),
      Integer.parseInt(tokens[6]),
      Integer.parseInt(tokens[13])
    );
  }

  public int distance(int time) {
    final int total = duration+rest;
    final int remain = time%total;

    return duration*speed*(time/total)+Math.min(duration,remain)*speed;
  }

}
