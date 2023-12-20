package fpc.aoc.day20;

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
  private final MutableCircuitState circuitState;
  private final List<Signal> toProcess = new LinkedList<>();
  private int nbLow = 1;
  private int nbHigh = 0;

  public ExecutionResult execute() {
    final var broadcast = circuit.getModule(Module.BROADCAST);
    broadcast.outputs().stream().map(n -> new Signal(broadcast.name(), n, Pulse.LOW)).forEach(toProcess::add);

    while (!toProcess.isEmpty()) {
      final var signal = toProcess.removeFirst();
      if (signal.pulse() == Pulse.LOW) {
        nbLow++;
      } else {
        nbHigh++;
      }

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
        module.outputs().stream().map(o -> new Signal(module.name(), o, emitted)).forEach(toProcess::addLast);
      }
    }

    return new ExecutionResult(nbLow, nbHigh, circuitState.fix());
  }

  private Pulse handleFlipFlop(Module.FlipFlop flipFlop, Pulse pulse) {
    if (pulse == Pulse.HIGH) {
      return null;
    }
    final var state = circuitState.getFlipFlopState(flipFlop.name());
    final var emittedPulse = state == FlipFlopState.ON ? Pulse.LOW : Pulse.HIGH;

    circuitState.setFlipFlopState(flipFlop.name(), state.toggle());

    return emittedPulse;
  }

  private Pulse handleConjunction(Module.Conjunction conjunction, Signal signal) {
    return circuitState.updateConjunctionState(conjunction.name(), signal.source(), signal.pulse());

  }
}
