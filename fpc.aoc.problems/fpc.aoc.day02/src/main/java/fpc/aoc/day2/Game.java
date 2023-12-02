package fpc.aoc.day2;

import java.util.Arrays;
import java.util.List;

public record Game(int id, List<Pick> picks){

  public boolean isValid(Pick max) {
    return picks.stream().allMatch(p -> p.isValid(max));
  }

  public int computePower() {
    final var reduce = this.picks.stream().reduce(Pick.ZERO,Pick::max);
    return reduce.red()*reduce.blue()*reduce.green();
  }

  public static Game parse(String line) {
    final var tokens = line.split(":");
    final var id = tokens[0].split(" ")[1];
    final var picks = Arrays.stream(tokens[1].split(";")).map(Pick::parse).toList();
    return new Game(Integer.parseInt(id),picks);
  }
}
