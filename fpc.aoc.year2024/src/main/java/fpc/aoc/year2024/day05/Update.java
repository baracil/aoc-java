package fpc.aoc.year2024.day05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Update {
  private final List<PageNumber> pages;
  private final Map<PageNumber, Integer> positions = new HashMap<>();

  public Update(List<PageNumber> pages) {
    this.pages = pages;
    for (int i = 0; i < pages.size(); i++) {
      positions.put(pages.get(i), i);
    }
  }

  public PageNumber getMiddlePageAfterOrdering(Contraints contraints) {
    final var lst = new ArrayList<>(pages);
    lst.sort(contraints);
    return lst.get(lst.size()/2);
  }

  public boolean isInCorrectOrder(Contraints contraints) {
    for (int position = 0; position < pages.size(); position++) {
      final var currentPage = pages.get(position);
      final var requestedPageAfter = contraints.getRequestedAfter(currentPage);
      for (PageNumber pageNumber : requestedPageAfter) {
        final var constraintPosition = positions.get(pageNumber);
        if (constraintPosition != null && constraintPosition<position) {
          return false;
        }
      }
    }
    return true;
  }

  public PageNumber getMiddlePage() {
    return pages.get(pages.size() / 2);
  }
}
