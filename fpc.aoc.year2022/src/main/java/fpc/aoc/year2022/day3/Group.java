package fpc.aoc.year2022.day3;

import fpc.aoc.common.AOCException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class Group {

  private final List<fpc.aoc.year2022.day3.Compartment> compartments;

  public int getCommonItem() {
    return IntStream.range(0, 52)
        .filter(this::isInAllCompartments)
        .findAny()
        .orElseThrow(() -> new AOCException("No common item in group"));
  }

  private boolean isInAllCompartments(int item) {
    for (fpc.aoc.year2022.day3.Compartment compartment : compartments) {
      if (!compartment.contains(item)) {
        return false;
      }
    }
    return true;
  }

}
