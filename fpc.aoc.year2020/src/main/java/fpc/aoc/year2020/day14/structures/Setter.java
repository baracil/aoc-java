package fpc.aoc.year2020.day14.structures;

import fpc.aoc.common.AOCException;
import lombok.Value;

import java.util.regex.Pattern;

@Value
public class Setter implements Instruction {

  int addr;
  long value;

  @Override
  public void applyToMemory(Memory memory) {
    memory.setValue(addr, value);
  }


  private static final Pattern SETTER_PATTERN = Pattern.compile("mem\\[(\\d+)] = (\\d+)");

  public static Setter parse(String line) {
    final var matcher = SETTER_PATTERN.matcher(line);
    if (matcher.matches()) {
      return new Setter(Integer.parseInt(matcher.group(1)),
          Long.parseLong(matcher.group(2)));
    }
    throw new AOCException("Could not parse line '" + line + "'");
  }


}
