package fpc.aoc.year2023.day20.model;

import fpc.aoc.year2023.day20.model.state.CircuitState;
import fpc.aoc.year2023.day20.model.state.FlipFlopState;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class CircuitExecution {

  public static ExecutionResult execute(Circuit circuit, CircuitState state) {
    return new CircuitExecution(circuit, state.makeCopy()).execute();
  }

  private final Circuit circuit;
  private final CircuitState.Mutable circuitState;
  private final List<Signal> toProcess = new LinkedList<>();
  private int nbLow = 1;
  private int nbHigh = 0;


  public ExecutionResult execute() {
    final var broadcast = circuit.getModule(Module.BROADCAST);

    this.addOutputToProcess(broadcast, Pulse.LOW);

    while (!toProcess.isEmpty()) {
      final var signal = toProcess.removeFirst();
      updatePulseCount(signal);

      if (!circuit.hasModule(signal.destination())) {
        continue;
      }

      final var module = circuit.getModule(signal.destination());

      final var emitted = switch (module) {
        case Module.FlipFlop flipFlop -> handleFlipFlop(flipFlop, signal.pulse());
        case Module.Conjunction conjunction -> handleConjunction(conjunction, signal);
        default -> null;
      };

      if (emitted != null) {
        this.addOutputToProcess(module, emitted);
      }
    }

    return new ExecutionResult(nbLow, nbHigh, circuitState.fix());
  }

  private void updatePulseCount(Signal signal) {
    if (signal.pulse() == Pulse.LOW) {
      nbLow++;
    } else {
      nbHigh++;
    }
  }

  private void addOutputToProcess(Module module, Pulse pulse) {
    module.outputs().stream().map(o -> new Signal(module.name(), o, pulse)).forEach(toProcess::addLast);
  }


  private Pulse handleFlipFlop(Module.FlipFlop flipFlop, Pulse pulse) {
    if (pulse == Pulse.HIGH) {
      return null;
    }
    final var state = circuitState.toggleFlipFlopState(flipFlop.name());
    return state == FlipFlopState.ON ? Pulse.LOW : Pulse.HIGH;
  }

  private Pulse handleConjunction(Module.Conjunction conjunction, Signal signal) {
    return circuitState.updateConjunctionState(conjunction.name(), signal.source(), signal.pulse());

  }

  private record Signal(String source, String destination, Pulse pulse) {
  }
}
