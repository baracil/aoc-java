package fpc.aoc.year2020.day4.structures;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.rules.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum FieldName {

  BYR("Birth Year", Rule.isFourDigitsBetween(1920, 2020)),
  IYR("Issue Year", Rule.isFourDigitsBetween(2010, 2020)),
  EYR("Expiration Year", Rule.isFourDigitsBetween(2020, 2030)),
  HGT("Height", Either.oneOf(
      EndsWith.suffix("cm").and(Rule.isIntegerBetween(150, 193)),
      EndsWith.suffix("in").and(Rule.isIntegerBetween(59, 76))
  )),
  HCL("Hair Color", StartsWith.prefix("#").and(HasSize.of(6)).and(AreAllHexDigits.create())),
  ECL("Eye Color", IsOneOf.these("amb", "blu", "brn", "gry", "grn", "hzl", "oth")),
  PID("Passport ID", HasSize.of(9).and(AreAllDigits.create())),
  CID("Country ID", Rule.alwaysValid()),
  ;

  @Getter
  private final @NonNull String description;

  private final Rule<String, ?> rule;

  @Getter
  private final @NonNull String id;

  FieldName(@NonNull String description, @NonNull Rule<String, ?> rule) {
    this.description = description;
    this.rule = rule;
    this.id = name().toLowerCase();
  }

  public boolean isValid(@NonNull String fieldValue) {
    return rule.validate(fieldValue).isValid();
  }


  public static @NonNull FieldName fromId(@NonNull String id) {
    final FieldName fieldName = Holder.FIELD_NAME_BY_ID.get(id.toLowerCase());
    if (fieldName == null) {
      throw new AOCException("Invalid id for password field : '" + id + "'");
    }
    return fieldName;
  }


  private static class Holder {

    private static final Map<String, FieldName> FIELD_NAME_BY_ID;

    static {
      FIELD_NAME_BY_ID = Arrays.stream(values()).collect(Collectors.toMap(FieldName::id, f -> f));
    }


  }
}
