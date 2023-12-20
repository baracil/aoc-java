package fpc.aoc.day20;

import fpc.aoc.common.Tools;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
public class MutableCircuitState {
  private final Map<String, FlipFlopState> flipFlopStates;
  private final Map<String, MutableConjunctionState> conjunctionStates;

  public FlipFlopState getFlipFlopState(String name) {
    return Objects.requireNonNull(flipFlopStates.get(name));
  }

  public void setFlipFlopState(String name, FlipFlopState flipFlopState) {
    flipFlopStates.put(name,flipFlopState);
  }

  public Pulse updateConjunctionState(String name, String source, Pulse pulse) {
    final var conjunctionState = Objects.requireNonNull(conjunctionStates.get(name));
    return conjunctionState.updateState(source,pulse);
  }

  public CircuitState fix() {
    return new CircuitState(flipFlopStates, Tools.mapValues(conjunctionStates, MutableConjunctionState::fix));
  }

}
