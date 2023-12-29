package fpc.aoc.year2022.day3;

import fpc.aoc.common.AOCException;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Rucksack {

  private final @NonNull Compartment first;
  private final @NonNull Compartment second;

  public int findItemInBothCompartments() {
    return first.items()
        .filter(second::contains)
        .findAny()
        .orElseThrow(() -> new AOCException("Could not find common item"));
  }

  public static @NonNull Rucksack parse(@NonNull String line) {
    final var size = line.length();
    final var first = Compartment.parse(line.substring(0, size / 2));
    final var second = Compartment.parse(line.substring(size / 2));
    return new Rucksack(first, second);
  }


}
