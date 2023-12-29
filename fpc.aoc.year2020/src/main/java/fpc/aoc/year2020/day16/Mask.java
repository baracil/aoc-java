package fpc.aoc.year2020.day16;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Mask {

  public static @NonNull Mask create(@NonNull Set<Field> fields) {
    final boolean[] inRangeFlags = new boolean[1000];
    fields.forEach(f -> f.setValidityFlags(inRangeFlags));
    return new Mask(inRangeFlags);
  }

  private final boolean[] inRangeFlags;

  public boolean isValid(int value) {
    return inRangeFlags[value];
  }

  public boolean isNotValid(int value) {
    return !inRangeFlags[value];
  }

  public boolean isValid(@NonNull Ticket ticket) {
    return ticket.values().allMatch(this::isValid);
  }
}
