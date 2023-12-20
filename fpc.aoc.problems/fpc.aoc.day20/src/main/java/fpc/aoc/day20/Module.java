package fpc.aoc.day20;

import fpc.aoc.common.AOCException;

import java.util.List;
import java.util.stream.IntStream;

public sealed interface Module {

  public static final String BROADCAST = "broadcast";

  String name();
  List<String> outputs();

  record FlipFlop(String name, List<String> outputs) implements Module {
  }

  record Conjunction(String name, List<String> outputs) implements Module {
  }

  record Broadcast(List<String> outputs) implements Module {
    @Override
    public String name() {
      return BROADCAST;
    }
  }

  record Button() implements Module {
    @Override
    public String name() {
      return "button";
    }

    @Override
    public List<String> outputs() {
      return List.of(BROADCAST);
    }
  }

  static Module parse(String line) {
    final var token = line.split("[- >,]+");
    final var outputs = IntStream.range(1, token.length).mapToObj(i -> token[i]).toList();


    if (token[0].equals("broadcaster")) {
      return new Broadcast(outputs);
    } else if (token[0].startsWith("&")) {
      return new Conjunction(token[0].substring(1), outputs);
    } else if (token[0].startsWith("%")) {
      return new FlipFlop(token[0].substring(1), outputs);
    } else {
      throw new AOCException("Cannot parse module from : '"+line+"'");
    }
  }
}
