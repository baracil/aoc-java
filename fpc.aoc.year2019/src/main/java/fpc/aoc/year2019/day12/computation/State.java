package fpc.aoc.year2019.day12.computation;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class State {

  public State(MoonSystem moonSystem, ToIntFunction<Vector> coordinateGetter) {
    this.p = new int[moonSystem.numberOfMoons()];
    this.v = new int[moonSystem.numberOfMoons()];
    for (int i = 0; i < moonSystem.numberOfMoons(); i++) {
      this.p[i] = coordinateGetter.applyAsInt(moonSystem.getMoon(i).position());
      this.v[i] = coordinateGetter.applyAsInt(moonSystem.getMoon(i).velocity());
    }

  }

  int[] p;

  int[] v;

  public State update() {
    final State newState = duplicate();
    for (int i = 0; i < p.length - 1; i++) {
      for (int j = i + 1; j < p.length; j++) {
        int f = Integer.signum(p[j] - p[i]);
        newState.v[i] += f;
        newState.v[j] -= f;
      }
    }
    for (int i = 0; i < p.length; i++) {
      newState.p[i] += newState.v[i];
    }

    return newState;
  }

  private State duplicate() {
    return new State(p.clone(), v.clone());
  }

  public static List<Moon> moons(State x, State y, State z) {
    return IntStream.range(0, x.p.length)
        .mapToObj(i -> new Moon(position(i, x, y, z), velocity(i, x, y, z)))
        .toList();
  }

  private static Vector position(int pos, State x, State y, State z) {
    return Vector.of(x.p[pos], y.p[pos], z.p[pos]);
  }

  private static Vector velocity(int pos, State x, State y, State z) {
    return Vector.of(x.v[pos], y.v[pos], z.v[pos]);
  }
}
