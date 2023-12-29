package fpc.aoc.year2023.day05.data;

import fpc.aoc.common.Tools;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.*;
import java.util.stream.Collector;

@RequiredArgsConstructor
@Value
public class Input {

  @Getter(AccessLevel.NONE)
  long[] seeds;
  List<Mapper> mappers;


  public long[] seeds1() {
    return this.seeds;
  }

  public List<Range> seeds2() {
    final List<Range> result = new ArrayList<>();
    for (int i = 0; i < seeds.length; i += 2) {
      result.add(new Range(seeds[i], seeds[i] + seeds[i + 1]));
    }
    return result;
  }


  public long map(long value) {
    long result = value;
    for (Mapper mapper : mappers) {
      result = mapper.map(result);
    }
    return result;
  }

  public List<Range> map(List<Range> ranges) {
    var result = ranges;
    for (Mapper mapper : mappers) {
      result = mapper.map(result);
    }
    return result;
  }

  public static final Collector<String, ?, Input> COLLECTOR = Collector.of(
    Agg::new,
    Agg::add,
    Agg::merge,
    Agg::build
  );


  private static class Agg {

    private Type current = null;
    private long[] seeds = null;
    private final Map<Type, List<Mapping>> mappers = new HashMap<>();

    public void add(String line) {
      if (line.startsWith("seeds:")) {
        this.seeds = Tools.toArrayOfLong(line.substring("seeds:".length()));
      } else if (line.contains("map:")) {
        this.current = Type.findType(line);
      } else if (!line.isBlank()) {
        final var tokens = Tools.toArrayOfLong(line);

        mappers.computeIfAbsent(this.current, t -> new ArrayList<>()).add(Mapping.with(tokens[0], tokens[1], tokens[2]));
      }
    }

    public Agg merge(Agg other) {
      throw new UnsupportedOperationException();
    }

    public Input build() {
      final var mappers = Arrays.stream(Type.values())
        .sorted(Comparator.comparing(Type::order))
        .map(t -> new Mapper(t, this.mappers.get(t)))
        .toList();

      return new Input(seeds, mappers);
    }

  }
}
