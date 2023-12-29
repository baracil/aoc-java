package fpc.aoc.year2022.day19;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;
import java.util.stream.Stream;

@EqualsAndHashCode(of = {"resources", "robots", "time"})
public class State {

  @Getter
  private final int time;
  private final BluePrint bluePrint;
  private final int[] resources;
  private final int[] robots;

  public State(int time, BluePrint bluePrint, int[] resources, int[] robots) {
    this.time = time;
    this.bluePrint = bluePrint;
    this.resources = resources;
    this.robots = robots;
  }

  public int getQualityLevel() {
    return resources[Type.GEODE.index] * bluePrint.id();
  }

  public long nbGeode() {
    return resources[Type.GEODE.index];
  }

  public static State initial(@NonNull BluePrint bluePrint) {
    final var nbTypes = Type.values().length;
    final var resources = new int[nbTypes];
    final var robots = new int[nbTypes];
    robots[Type.ORE.index] = 1;
    return new State(0, bluePrint, resources, robots);
  }

  public Stream<State> next(int maxTime) {
    final var n1 = next(Type.ORE, maxTime);
    final var n2 = next(Type.CLAY, maxTime);
    final var n3 = next(Type.OBSIDIAN, maxTime);
    final var n4 = next(Type.GEODE, maxTime);
    final var n0 = (n1 == null || n2 == null || n3 == null || n4 == null) ? noBuildAtAll(maxTime) : null;

    return Stream.of(n1, n2, n3, n4, n0).filter(Objects::nonNull);
  }

  private State noBuildAtAll(int maxTime) {
    final var newResources = resources.clone();
    final var newRobots = robots.clone();

    for (int i = 0; i < newResources.length; i++) {
      newResources[i] += newRobots[i] * (maxTime - time);
    }
    return new State(maxTime, bluePrint, newResources, newRobots);
  }

  private State next(Type builtRobot, int maxTime) {
    final var newResources = resources.clone();
    final var newRobots = robots.clone();

    final var cost = bluePrint.getCost(builtRobot);
    final var timeBeforePossible = 1 + getTimeNeeded(cost);
    if (timeBeforePossible == 0) {
      return null;
    }

    if (timeBeforePossible + time >= maxTime) {
      return null;
    }

    for (int i = 0; i < newResources.length; i++) {
      newResources[i] += newRobots[i] * (timeBeforePossible) - cost[i];
    }
    newRobots[builtRobot.index]++;
    return new State(time + timeBeforePossible, bluePrint, newResources, newRobots);
  }

  private int getTimeNeeded(int[] cost) {
    int t = 0;
    for (int i = 0; i < cost.length; i++) {
      final var missing = cost[i] - resources[i];
      if (missing <= 0) {
        continue;
      }
      if (robots[i] == 0) {
        return -1;
      }
      t = Math.max(1 + ((missing - 1) / robots[i]), t);
    }
    return t;
  }


  public int atMost(@NonNull Type type, int nbRound) {
    int left = nbRound - time;
    return resources[type.index] + left * robots[type.index] + left * (left - 1) / 2;

  }
}
