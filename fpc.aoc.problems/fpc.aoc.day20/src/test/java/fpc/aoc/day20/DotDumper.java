package fpc.aoc.day20;

import fpc.aoc.day20.model.Circuit;
import fpc.aoc.day20.model.Module;
import fpc.aoc.day20.model.state.CircuitState;
import fpc.aoc.day20.model.state.FlipFlopState;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DotDumper {

  public static void dump(Circuit circuit, CircuitState circuitState, String name) {
    try {
      new DotDumper(circuit,circuitState, name).dump();
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  private final Circuit circuit;
  private final CircuitState state;
  private final String name;

  private void dump() throws IOException {

    try(var ps = new PrintStream(Files.newOutputStream(Path.of(name)))) {
      ps.println("digraph {");
      for (Module module : circuit) {
        if (module instanceof Module.FlipFlop) {
          final var s = state.flipFlopStates().get(module.name());
          ps.println(module.name()+"[fillcolor=\"%s\", style=\"filled\"]".formatted(s == FlipFlopState.ON?"red":"green"));
        } else if (module instanceof Module.Conjunction) {
          ps.println(module.name()+"[fillcolor=\"blue\", style=\"filled\"]");
        }
        for (String output : module.outputs()) {
          ps.println(module.name()+" -> "+output);
        }
      }
      ps.println("}");
    }
  }
}
