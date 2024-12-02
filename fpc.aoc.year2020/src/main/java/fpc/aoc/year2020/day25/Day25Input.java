package fpc.aoc.year2020.day25;

import lombok.Value;

import java.util.List;

@Value
public class Day25Input {
  int doorPublicKey;
  int cardPublicKey;

  public static Day25Input parse(List<String> strings) {
    return new Day25Input(Integer.parseInt(strings.get(0)), Integer.parseInt(strings.get(1)));
  }
}
