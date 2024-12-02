package fpc.aoc.year2020.day14.structures;

public interface Memory {

  void setValue(int address, long value);

  void setActiveMask(Mask mask);

  long sumOfAllValues();
}
