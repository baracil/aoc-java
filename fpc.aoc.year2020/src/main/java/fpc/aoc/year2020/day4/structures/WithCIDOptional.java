package fpc.aoc.year2020.day4.structures;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WithCIDOptional implements ValidityRule {

  private final @NonNull Set<FieldName> compulsoryFields = Arrays.stream(FieldName.values())
      .filter(f -> f != FieldName.CID)
      .collect(Collectors.toSet());

  @Override
  public boolean isValid(@NonNull Passport passport) {
    return passport.hasFields(compulsoryFields);
  }
}
