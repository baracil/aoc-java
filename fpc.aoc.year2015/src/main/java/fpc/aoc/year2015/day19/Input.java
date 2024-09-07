package fpc.aoc.year2015.day19;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collector;

@RequiredArgsConstructor
public class Input {

  private final Map<String, List<String>> transformations;
  private final Map<String,String> reversed;
  @Getter
  private final String molecule;


  public Set<String> reactants() {
    return transformations.keySet();
  }

  public String getReactant(String product) {
    return reversed.get(product);
  }

  public List<String> getProducts(String molecule) {
    return transformations.getOrDefault(molecule, List.of());
  }

  public boolean isReactant(String value) {
    return transformations.containsKey(value);
  }

  public static Collector<String, ?, Input> COLLECTOR = Collector.of(
    Agg::new, Agg::add, Agg::merge, Agg::build
  );


  private static class Agg {
    private final Map<String, List<String>> transformations = new HashMap<>();
    private final Map<String,String> reversed = new HashMap<>();

    private String molecule = null;
    private boolean inTransform = true;

    public void add(String line) {
      if (line.isEmpty()) {
        inTransform = false;
        return;
      }
      if (inTransform) {
        final var token = line.split(" +");
        final var from = token[0];
        final var to = token[2];
        reversed.put(to,from);
        transformations.computeIfAbsent(from, s -> new ArrayList<>()).add(to);
      } else {
        molecule = line;
      }
    }

    public Agg merge(Agg other) {
      throw new UnsupportedOperationException();
    }

    public Input build() {
      return new Input(transformations, reversed, molecule);
    }
  }
}
