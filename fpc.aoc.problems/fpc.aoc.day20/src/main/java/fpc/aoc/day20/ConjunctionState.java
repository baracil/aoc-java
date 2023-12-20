package fpc.aoc.day20;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Value
public class ConjunctionState {
  @Getter(AccessLevel.NONE)
  Map<String, Pulse> states;


  public MutableConjunctionState makeCopy() {
    return new MutableConjunctionState(new HashMap<>(states));
  }

  public static ConjunctionState initial(List<String> inputNames) {
    final var states = inputNames.stream().collect(Collectors.toMap(n -> n, n -> Pulse.LOW));
    return new ConjunctionState(states);
  }
}
