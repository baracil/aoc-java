package fpc.aoc.year2015.day13;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Day13Part2Solver extends Day13Solver {

  public static @NonNull Solver provider() {
    return new Day13Part2Solver();
  }

  @Override
  protected List<Link> prepare(List<Link> links) {
    final var l = new ArrayList<>(links);

    links.stream()
      .map(Link::target)
      .distinct()
      .forEach(t -> {
        l.add(new Link("me", 0, t));
        l.add(new Link(t, 0, "me"));
      });

    return l;
  }
}
