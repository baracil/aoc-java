package fpc.aoc.year2015.day13;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SolverDay13 {

  public static int solve(List<Link> links) {
    final var names = links.stream().map(Link::target).distinct().toList();
    final var size = names.size();

    final var weights = new int[size][size];


    final var map = IntStream.range(0, size).boxed().collect(Collectors.toMap(names::get, i -> i));

    for (Link link : links) {
      weights[map.get(link.target())][map.get(link.neighbour())] = link.happiness();
    }

    return new SolverDay13(weights, new boolean[size]).solve();
  }

  private final int[][] weights;
  private final boolean[] used;

  private int solve() {
    Arrays.fill(used,false);
    used[0] = true;

    return solve(0,0);
  }

  private int solve(int idx, int current) {
    int max = Integer.MIN_VALUE;
    boolean done = true;
    for (int i = 0; i < used.length; i++) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      done = false;
      final var d = solve(i,current+weights[idx][i]+weights[i][idx]);
      max = Math.max(d,max);
      used[i] = false;
    }

    if (done) {
      return current+weights[idx][0]+weights[0][idx];
    } else {
      return max;
    }
  }
}
