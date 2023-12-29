package fpc.aoc.year2020.day13;

import fpc.aoc.common.AOCException;
import lombok.NonNull;
import lombok.Value;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Value
public class Notes {

  public static @NonNull Notes parse(@NonNull List<String> lines) {
    return switch (lines.size()) {
      case 0 -> throw new AOCException("Invalid input");
      case 1 -> parsePart2(lines.get(0));
      default -> parsePart1(lines.get(0), lines.get(1));
    };
  }

  public static @NonNull Notes parsePart1(@NonNull String firstLine, @NonNull String secondLine) {
    final long departTime = Long.parseLong(firstLine);
    final var ids = Arrays.stream(secondLine.split(","))
        .map(Bus::parse)
        .toList();
    return new Notes(BigInteger.valueOf(departTime), ids);
  }

  public static @NonNull Notes parsePart2(@NonNull String busIds) {
    return parsePart1("0", busIds);
  }

  @NonNull BigInteger departTime;

  @NonNull List<Bus> buses;


  public @NonNull NextStop findNextStop() {
    return buses.stream()
        .map(b -> b.findNextStop(departTime))
        .flatMap(Optional::stream)
        .min(Comparator.comparing(NextStop::waitingTime))
        .orElseThrow(() -> new AOCException("No bus available!!"));
  }

}
