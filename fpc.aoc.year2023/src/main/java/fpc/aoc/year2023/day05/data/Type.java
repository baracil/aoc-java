package fpc.aoc.year2023.day05.data;

import fpc.aoc.common.AOCException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Type {
  SEED_TO_SOIL(0,"seed-to-soil"),
  SOIL_TO_FERTILIZER(1,"soil-to-fertilizer"),
  FERTILIZER_TO_WATER(2,"fertilizer-to-water"),
  WATER_TO_LIGHT(3,"water-to-light"),
  LIGHT_TO_TEMPERATURE(4,"light-to-temperature"),
  TEMPERATURE_TO_HUMIDITY(5,"temperature-to-humidity"),
  HUMIDITY_TO_LOCATION(6,"humidity-to-location"),
  ;

  private final int order;
  private final String tag;

  public static Type findType(String line) {
    for (Type value : Type.values()) {
      if (line.contains(value.tag)) {
        return value;
      }
    }
    throw new AOCException("Invalid line : '"+line+"'");

  }
}
