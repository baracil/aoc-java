package fpc.aoc.day5.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RangeTool {


  public static List<Range> merge(List<Range> ranges) {
    return split(ranges, List.of());
  }

  public static List<Range> split(List<Range> ranges, List<Mapping> mappings) {
    final List<Tick> ticks = new ArrayList<>(ranges.size() + mappings.size());
    for (Range range : ranges) {
      ticks.add(new Tick(range.start(), true, false));
      ticks.add(new Tick(range.end(), false, false));
    }
    for (Mapping mapping : mappings) {
      ticks.add(new Tick(mapping.start(), true, true));
      ticks.add(new Tick(mapping.end(), false, true));
    }
    return getRanges(ticks);
  }

  private static List<Range> getRanges(List<Tick> ticks) {
    ticks.sort(Tick.COMPARATOR);
    long start = 0;
    int counter = 0;

    List<Range> result = new ArrayList<>();

    for (Tick tick : ticks) {
      if (tick.start && !tick.mapping) {
        if (counter == 0) {
          start = tick.position;
        }
        counter++;
      } else if (tick.start || tick.mapping) {
        if (counter != 0) {
          result.add(new Range(start, tick.position));
          start = tick.position;
        }
      } else {

        counter--;
        if (counter == 0) {
          result.add(new Range(start, tick.position));
        }
      }
    }
    return result;
  }

  private record Tick(long position, boolean start, boolean mapping) {

    public static final Comparator<Tick> COMPARATOR = (o1, o2) -> {
      if (o1.equals(o2)) {
        return 0;
      }
      final var result = Long.compare(o1.position, o2.position);
      if (result != 0) {
        return result;
      }

      if (o1.mapping == o2.mapping) {
        return o1.start ? -1 : 1;
      } else {
        return o1.start ? 1 : -1;
      }
    };
  }


}
