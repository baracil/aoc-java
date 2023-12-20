package fpc.aoc.day20;

import fpc.aoc.api.Day;
import fpc.aoc.input.ResourceFile;

import java.io.IOException;

public class DumpDot {

  public static void main(String[] args) throws IOException {
    final var modules = new ResourceFile(Day.DAY_20).readData().map(Module::parse).toList();
    final var circuit = Circuit.create(modules);

    DotDumper.dump(circuit,circuit.initialState(),"day20.dot");
  }
}
