package fpc.aoc.year2022.day19;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

@RequiredArgsConstructor
public class BluePrint {
  @Getter
  private final int id;
  private final int[][] cost;


  public int[] getCost(Type type) {
    return cost[type.index];
  }

  //Blueprint 22:
  // Each ore robot costs 3 ore.
  // Each clay robot costs 3 ore.
  // Each obsidian robot costs 3 ore and 16 clay.
  // Each geode robot costs 3 ore and 20 obsidian.
  public static @NonNull BluePrint parse(@NonNull String line) {
    final var tokens = line.split("[ :.]");
    final var ints = IntStream.of(1, 7, 14, 21, 24, 31, 34).map(i -> Integer.parseInt(tokens[i])).toArray();

    final var costs = new int[4][4];

    costs[0][0] = ints[1];
    costs[1][0] = ints[2];
    costs[2][0] = ints[3];
    costs[2][1] = ints[4];
    costs[3][0] = ints[5];
    costs[3][2] = ints[6];

    return new BluePrint(ints[0], costs);
  }

}
