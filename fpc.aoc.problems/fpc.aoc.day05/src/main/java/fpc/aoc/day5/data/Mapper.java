package fpc.aoc.day5.data;

import lombok.Value;

import java.util.List;

@Value
public class Mapper {

  Type type;
  List<Mapping> mappings;

  public Mapper(Type type, List<Mapping> mappings) {
    this.type = type;
    this.mappings = mappings;
  }

  public long map(long value) {
    for (Mapping mapping : mappings) {
      if (mapping.isInside(value)) {
        return value + mapping.shift();
      }
    }
    return value;
  }

  public List<Range> map(List<Range> ranges) {
    final var list = RangeTool.split(ranges,mappings);

    return RangeTool.merge(list
      .stream()
      .map(this::apply)
      .toList());
  }

  private Range apply(Range r) {
    for (Mapping mapping : mappings) {
      if (mapping.isInside(r.start())) {
        return r.shift(mapping.shift());
      }
    }
    return r;
  }

}
