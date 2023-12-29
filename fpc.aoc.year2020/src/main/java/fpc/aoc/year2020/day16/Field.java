package fpc.aoc.year2020.day16;

import fpc.aoc.common.AOCException;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

import java.util.regex.Pattern;

@Value
@EqualsAndHashCode(of = "name")
public class Field {
  @NonNull String name;
  @NonNull IntRange firstRange;
  @NonNull IntRange secondRange;

  public boolean isValid(int value) {
    return firstRange.isInRange(value) || secondRange.isInRange(value);
  }

  public void setValidityFlags(boolean[] input) {
    firstRange.setValidityFlag(input);
    secondRange.setValidityFlag(input);
  }

  @Override
  public String toString() {
    //route: 44-251 or 264-959
    return name + ": " + firstRange.lower() + "-" + firstRange.upper() + " or " + secondRange.lower() + "-" + secondRange.upper();
  }

  private static final Pattern PATTERN = Pattern.compile("([a-z ]+): (\\d+)-(\\d+) or (\\d+)-(\\d+)");

  public static @NonNull Field parse(@NonNull String line) {
    final var matcher = PATTERN.matcher(line);
    if (!matcher.matches()) {
      throw new AOCException("Cannot parse field '" + line + "'");
    }
    final var name = matcher.group(1);
    final var firstRange = IntRange.parse(matcher.group(2), matcher.group(3));
    final var secondRange = IntRange.parse(matcher.group(4), matcher.group(5));
    return new Field(name, firstRange, secondRange);
  }


  public boolean nameStartsWith(@NonNull String prefix) {
    return name.startsWith(prefix);
  }
}
