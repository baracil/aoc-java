package fpc.aoc.year2023.day20.model.state;

import fpc.aoc.year2023.day20.model.Pulse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Value
public class ConjunctionState {
  @Getter(AccessLevel.NONE)
  Map<String, Pulse> states;


  public Mutable makeCopy() {
    return new Mutable(new HashMap<>(states));
  }

  public static ConjunctionState initial(List<String> inputNames) {
    final var states = inputNames.stream().collect(Collectors.toMap(n -> n, n -> Pulse.LOW));
    return new ConjunctionState(states);
  }

  @RequiredArgsConstructor
  public static class Mutable {
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
}
