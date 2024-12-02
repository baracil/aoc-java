package fpc.aoc.api;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Tools;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

@RequiredArgsConstructor
@Getter
public enum Year {
  YEAR_2015(2015),
  YEAR_2016(2016),
  YEAR_2017(2017),
  YEAR_2018(2018),
  YEAR_2019(2019),
  YEAR_2020(2020),
  YEAR_2021(2021),
  YEAR_2022(2022),
  YEAR_2023(2023),
  YEAR_2024(2024),
  ;

  private final int numericalValue;

  public static final Comparator<Year> YEAR_COMPARATOR = Comparator.comparing(d -> d.numericalValue);

  @NonNull
  public static Year parse(String value) {
    final Predicate<Year> predicate = Tools.parseInteger(value)
        .map(Year::predicateOnNumericalValue)
        .orElseGet(() -> predicateOnName(value));
    return Arrays.stream(values())
        .filter(predicate)
        .findFirst()
        .orElseThrow(() -> new AOCException("Could not convert '" + value + "' to a Year"));
  }


  public SolverId createIdWith(Day day, Part part) {
    return new SolverId(this, day, part);
  }

  @NonNull
  private static Predicate<Year> predicateOnNumericalValue(int numericalValue) {
    return year -> year.numericalValue == numericalValue;
  }

  @NonNull
  private static Predicate<Year> predicateOnName(String name) {
    return year -> year.name().equalsIgnoreCase(name);
  }

}
