package fpc.aoc.day20;

import fpc.aoc.common.Tools;
import lombok.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
@ToString
@Getter
public class CircuitState {
  private final Map<String, FlipFlopState> flipFlopStates;
  private final Map<String, ConjunctionState> conjunctionStates;

  @Builder
  public CircuitState(@Singular Map<String, FlipFlopState> flipFlopStates, @Singular Map<String, ConjunctionState> conjunctionStates) {
    this.flipFlopStates = Collections.unmodifiableMap(flipFlopStates);
    this.conjunctionStates = Collections.unmodifiableMap(conjunctionStates);
  }

  public MutableCircuitState makeCopy() {
    final var flipFlopCopy = new HashMap<>(flipFlopStates);
    final var conjunctionCopy = Tools.mapValues(this.conjunctionStates, ConjunctionState::makeCopy);
    return new MutableCircuitState(flipFlopCopy, conjunctionCopy);
  }
}
