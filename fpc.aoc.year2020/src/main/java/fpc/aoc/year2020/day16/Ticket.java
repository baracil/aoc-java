package fpc.aoc.year2020.day16;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class Ticket {

  private final @NonNull int[] values;

  public static @NonNull Ticket parse(@NonNull String line) {
    final var values = Arrays.stream(line.split(","))
        .mapToInt(Integer::parseInt)
        .toArray();
    return new Ticket(values);
  }

  public int getValueAt(int index) {
    return values[index];
  }

  public @NonNull IntStream values() {
    return Arrays.stream(values);
  }

  @Override
  public String toString() {
    return "RawTicket{" +
        "values=" + Arrays.toString(values) +
        '}';
  }
}
