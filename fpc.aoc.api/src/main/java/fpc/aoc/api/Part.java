package fpc.aoc.api;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Tools;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.function.Predicate;

@Getter
@RequiredArgsConstructor
public enum Part {
  PART_1(1),
  PART_2(2),
  ;

  private final int numericalValue;

  @NonNull
  public static Part parse(@NonNull String value) {
    final Predicate<Part> predicate = Tools.parseInteger(value)
        .map(Part::predicateOnNumericalValue)
        .orElseGet(() -> predicateOnName(value));

    return Arrays.stream(values())
        .filter(predicate)
        .findFirst()
        .orElseThrow(() -> new AOCException("Could not convert '" + value + "' to a Part"));
  }

  @NonNull
  private static Predicate<Part> predicateOnNumericalValue(int numericalValue) {
    return part -> part.numericalValue == numericalValue;
  }

  @NonNull
  private static Predicate<Part> predicateOnName(@NonNull String name) {
    return part -> part.name().equalsIgnoreCase(name);
  }


}
