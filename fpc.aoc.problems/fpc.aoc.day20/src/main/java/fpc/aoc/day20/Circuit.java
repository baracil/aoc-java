package fpc.aoc.day20;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
public class Circuit implements Iterable<Module> {

  private final Map<String,Module> modules;
  @Getter
  private final CircuitState initialState;

  public ExecutionResult execute(CircuitState state) {
    return CircuitExecution.execute(this, state);
  }


  public boolean hasModule(String name) {
    return modules.containsKey(name);
  }

  public Module getModule(String name) {
    return Objects.requireNonNull(modules.get(name));
  }

  @Override
  public Iterator<Module> iterator() {
    return modules.values().iterator();
  }

  public static Circuit create(List<Module> modules) {
    final Map<String,List<String>> inputs = new HashMap<>();

    for (Module module : modules) {
      module.outputs().forEach(s -> inputs.computeIfAbsent(s, x -> new ArrayList<>()).add(module.name()));
    }

    final var stateBuilder = CircuitState.builder();
    final Map<String,Module> moduleByName = new HashMap<>();

    for (Module module : modules) {
      moduleByName.put(module.name(),module);
      switch (module) {
        case Module.FlipFlop flipFlop -> stateBuilder.flipFlopState(flipFlop.name(), FlipFlopState.OFF);
        case Module.Conjunction conjunction -> {
          final var name = conjunction.name();
          final var input = inputs.get(name);
          stateBuilder.conjunctionState(name, ConjunctionState.initial(input));
        }
        default -> {}
      }
    }

    return new Circuit(moduleByName,stateBuilder.build());
  }

}
