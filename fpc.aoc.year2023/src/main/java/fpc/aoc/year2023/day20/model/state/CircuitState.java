package fpc.aoc.year2023.day20.model.state;

import fpc.aoc.common.Tools;
import fpc.aoc.year2023.day20.model.Pulse;
import lombok.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

  public Mutable makeCopy() {
    final var flipFlopCopy = new HashMap<>(flipFlopStates);
    final var conjunctionCopy = Tools.mapValues(this.conjunctionStates, ConjunctionState::makeCopy);
    return new Mutable(flipFlopCopy, conjunctionCopy);
  }

  @RequiredArgsConstructor
  public static class Mutable {

    private final Map<String, FlipFlopState> flipFlopStates;
    private final Map<String, ConjunctionState.Mutable> conjunctionStates;

    public FlipFlopState toggleFlipFlopState(String name) {
      final var current = Objects.requireNonNull(flipFlopStates.get(name));
      flipFlopStates.put(name,current.toggle());
      return current;
    }

    public Pulse updateConjunctionState(String name, String source, Pulse pulse) {
      final var conjunctionState = Objects.requireNonNull(conjunctionStates.get(name));
      return conjunctionState.updateState(source,pulse);
    }

    public CircuitState fix() {
      return new CircuitState(flipFlopStates, Tools.mapValues(conjunctionStates, ConjunctionState.Mutable::fix));
    }

  }
}
