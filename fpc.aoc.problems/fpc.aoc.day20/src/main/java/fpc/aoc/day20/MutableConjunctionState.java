package fpc.aoc.day20;

import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class MutableConjunctionState {
  private final Map<String, Pulse> states;

  public Pulse updateState(String source, Pulse pulse) {
    this.states.put(source,pulse);
    final var allHigh = this.states.values().stream().allMatch(p -> p == Pulse.HIGH);
    return allHigh?Pulse.LOW:Pulse.HIGH;
  }

  public ConjunctionState fix() {
    return new ConjunctionState(new HashMap<>(states));
  }
}
