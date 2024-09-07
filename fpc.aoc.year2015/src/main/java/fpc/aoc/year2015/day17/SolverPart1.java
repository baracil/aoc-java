package fpc.aoc.year2015.day17;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SolverPart1 {

  public static int solve(int limit, int[] sizes) {
    return new SolverPart1(limit, sizes).solve();
  }

  private final int limit;
  private final int[] sizes;

  private int count;

  private int solve() {
    solve(0, 0);
    return count;
  }

  public void solve(int sum, int idx) {
    if (sum > limit) {
      return;
    }
    if (idx >= sizes.length) {
      count += sum == limit ? 1 : 0;
    } else {
      solve(sum+sizes[idx],idx+1);
      solve(sum,idx+1);
    }
  }


}
