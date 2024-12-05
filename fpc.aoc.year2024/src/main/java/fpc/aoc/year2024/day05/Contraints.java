package fpc.aoc.year2024.day05;

import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
public class Contraints implements Comparator<PageNumber> {

  private final Map<PageNumber, Set<PageNumber>> constraints;

  public Set<PageNumber> getRequestedAfter(PageNumber page) {
    return constraints.getOrDefault(page,Set.of());
  }

  @Override
  public int compare(PageNumber o1, PageNumber o2) {
    if (constraints.getOrDefault(o1, Set.of()).contains(o2)) {
      return -1;
    } else if (constraints.getOrDefault(o2, Set.of()).contains(o1)) {
      return 1;
    }
    return 0;
  }
}
