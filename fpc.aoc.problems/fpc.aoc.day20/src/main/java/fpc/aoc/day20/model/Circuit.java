package fpc.aoc.day20.model;

import fpc.aoc.day20.model.state.CircuitState;
import fpc.aoc.day20.model.state.ConjunctionState;
import fpc.aoc.day20.model.state.FlipFlopState;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
public class Circuit implements Iterable<Module> {

  private final Map<String, Module> modules;
  @Getter
  private final CircuitState initialState;


  public List<Circuit> split() {
    final var broadcast = modules.get(Module.BROADCAST);

    return broadcast.outputs()
        .stream()
        .map(this::extract).toList();
  }

  private Circuit extract(String root) {
    final var seen = new HashSet<String>();
    final var toProcess = new LinkedList<String>();
    toProcess.add(root);
    while (!toProcess.isEmpty()) {
      final var module = modules.get(toProcess.removeFirst());

      if (!seen.add(module.name())) {
        continue;
      }

      if (module instanceof Module.Conjunction) {
        for (String output : module.outputs()) {
          final var child = modules.get(output);
          if (child instanceof Module.FlipFlop) {
            toProcess.add(output);
          }
        }
      } else {
        toProcess.addAll(module.outputs());
      }
    }

    final var subModules = new ArrayList<Module>(seen.size() + 1);
    subModules.add(new Module.Broadcast(List.of(root)));
    for (String name : seen) {
      subModules.add(modules.get(name));
    }
    return Circuit.create(subModules);
  }

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
    final Map<String, List<String>> inputs = new HashMap<>();

    for (Module module : modules) {
      for (String output : module.outputs()) {
        inputs.computeIfAbsent(output, x -> new ArrayList<>()).add(module.name());
      }
    }

    final var stateBuilder = CircuitState.builder();
    final Map<String, Module> moduleByName = new HashMap<>();

    for (Module module : modules) {
      moduleByName.put(module.name(), module);
      switch (module) {
        case Module.FlipFlop flipFlop -> stateBuilder.flipFlopState(flipFlop.name(), FlipFlopState.OFF);
        case Module.Conjunction conjunction -> {
          final var name = conjunction.name();
          final var input = inputs.get(name);
          stateBuilder.conjunctionState(name, ConjunctionState.initial(input));
        }
        default -> {
        }
      }
    }

    return new Circuit(moduleByName, stateBuilder.build());
  }

}
