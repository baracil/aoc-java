package fpc.aoc.year2022.day16;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class State {
  private final Valves valves;
  private final String path;
  private final int position;
  private final int valveState;
  private final int timeLeft;
  private final int rate;
  private final int total;


  public boolean isOpened(int valve) {
    return (this.valveState & valves.mask(valve)) != 0;
  }

  public State(Valves valves, int initialValveState, int timeLeft) {
    this.valves = valves;
    this.path = "AA";
    this.position = 0;
    this.valveState = initialValveState | valves.mask(0);
    this.timeLeft = timeLeft;
    this.rate = 0;
    this.total = 0;
  }

  public int totalAtTheEnd() {
    return  total + rate * timeLeft;
  }

  public State withNewValve(int toOpen) {
    final var timeToOpen = 1 + valves.distances(this.position, toOpen);
    final var newRate = rate + valves.rate(toOpen);
    final var newTotal = total + rate * timeToOpen;

    return new State(
        valves,
        path + valves.name(toOpen),
        toOpen,
        this.valveState | valves.mask(toOpen),
        timeLeft - timeToOpen,
        newRate,
        newTotal);
  }

  public boolean allOpened() {
    return valves().allOpened(valveState);
  }
}
