package fpc.aoc.year2015.day7.data;

import java.util.Map;

public sealed interface Operand {

  Long get(Map<String,Long> values);

  String name();

  record Wire(String name) implements Operand {
    @Override
    public Long get(Map<String, Long> values) {
      return values.get(name);
    }
  }
  record Value(long value) implements Operand {
    @Override
    public Long get(Map<String, Long> values) {
      return value;
    }

    @Override
    public String name() {
      return null;
    }
  }

  static Operand parse(String value) {
    try {
      return new Value(Long.parseLong(value));
    } catch (NumberFormatException e) {
      return new Wire(value);
    }
  }
}
