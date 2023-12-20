package fpc.aoc.day20;

import fpc.aoc.api.Day;
import fpc.aoc.day20.model.Circuit;
import fpc.aoc.day20.model.Module;
import fpc.aoc.input.ResourceFile;

public class DumpDot {

  public static void main(String[] args) {
    final var modules = new ResourceFile(Day.DAY_20).readData().map(Module::parse).toList();
    final var circuit = Circuit.create(modules);

    DotDumper.dump(circuit,circuit.initialState(),"day20.dot");
  }
}
