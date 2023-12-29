package fpc.aoc.year2020.day14.structures;

import lombok.NonNull;
import lombok.Value;

import java.util.stream.LongStream;

@Value
public class Mask implements Instruction {

  long maskValue;
  long floatingMask;
  long notFloatingMask;


  public long computeEffectiveValues(long value) {
    return (value & floatingMask) | (notFloatingMask & maskValue);
  }


  @Override
  public void applyToMemory(@NonNull Memory memory) {
    memory.setActiveMask(this);
  }


  public static @NonNull Mask parse(@NonNull String line) {
    final String mask = line.substring("mask = ".length()).trim();
    long maskValue = 0;
    long floatingMask = 0;
    long bit = 1;
    for (int i = 0; i < mask.length(); i++) {
      switch (mask.charAt(mask.length() - 1 - i)) {
        case '1' -> maskValue |= bit;
        case 'X' -> floatingMask |= bit;
      }
      bit = bit * 2;
    }

    return new Mask(maskValue, floatingMask, (~floatingMask & 0xFFFFFFFFFL));
  }


  public @NonNull LongStream generateFloatingAddresses(int address) {
    final long root = (address | maskValue) & notFloatingMask;
    return FloatingGenerator.generate(floatingMask).map(m -> m | root);
  }
}
