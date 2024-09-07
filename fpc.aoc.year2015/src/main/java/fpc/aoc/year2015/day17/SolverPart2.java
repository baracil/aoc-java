package fpc.aoc.year2015.day17;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SolverPart2 {

  public static int solve(int limit, int[] sizes) {
    return new SolverPart2(limit,sizes).solve();
  }

  private final int limit;
  private final int[] sizes;

  private int count = 0;
  private int size = Integer.MAX_VALUE;

  private int solve() {
    solve(0,0,0);
    return count;
  }

  public void solve(int sum, int idx,int nb) {
    if (sum>limit) {
      return;
    }
    if (idx>=sizes.length) {
      if (sum != limit || nb > size) {
        return;
      }
      if (nb == size) {
        count++;
      } else  {
        size  = nb;
        count = 1;
      }
    } else {
      solve(sum+sizes[idx],idx+1,nb+1);
      solve(sum,idx+1,nb);
    }
  }

  private record Match(int count, int nb){};

}
