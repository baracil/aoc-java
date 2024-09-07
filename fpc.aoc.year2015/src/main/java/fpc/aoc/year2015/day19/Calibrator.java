package fpc.aoc.year2015.day19;

import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class Calibrator {

  public static long calibrate(Input input) {
      return new Calibrator(input).calibrate();
  }

  private final Input input;

  private long calibrate() {
    final Set<String> seen = new HashSet<>();

    for (var reactant : input.reactants()) {
      final var products = input.getProducts(reactant);
      for (String product : products) {
        calibrate(reactant, product, seen);
      }
    }
    return seen.size();
  }

  private void calibrate(String reactant, String replacement, Set<String> seen) {
    int idx = 0;
    final var molecule = input.molecule();
    do {
      idx = molecule.indexOf(reactant, idx);
      if (idx < 0) {
        return;
      }
      final var newString = StrTool.replace(molecule, reactant, idx, replacement);
      seen.add(newString);
      idx++;
    } while (true);
  }
}
