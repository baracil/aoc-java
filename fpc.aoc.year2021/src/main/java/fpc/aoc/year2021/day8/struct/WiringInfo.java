package fpc.aoc.year2021.day8.struct;

import lombok.NonNull;

import java.util.List;

public record WiringInfo<T>(List<T> numbers,
                            List<T> digits) {

  public static @NonNull WiringInfo<String> parse(@NonNull String line) {
    final var tokens = line.split("\\|");
    final var numbers = List.of(tokens[0].trim().split(" "));
    final var digits = List.of(tokens[1].trim().split(" "));
    return new WiringInfo<>(numbers, digits);
  }


  public static int display(@NonNull WiringInfo<Integer> wiringInfo) {
    return wiringInfo.digits().stream().reduce(0, (n, d) -> n * 10 + d);
  }

}
