package fpc.aoc.year2023.day19.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class Workflow {

  @Getter
  private final String name;
  @Getter
  private final List<Dispatcher> dispatchers;
  @Getter
  private final String fallbackWorkflowName;

  public String process(Scrap scrap) {
    for (Dispatcher dispatcher : dispatchers) {
      final var check = dispatcher.check(scrap);
      if (check != null) {
        return check;
      }
    }
    return fallbackWorkflowName;
  }

  public Map<String, List<MultiScrap>> process(MultiScrap scrap) {
    final var map = new HashMap<String, List<MultiScrap>>();

    var current = scrap;

    for (Dispatcher dispatcher : dispatchers) {
      var tested = dispatcher.check(current);
      var wkName = dispatcher.workflowName();

      tested.getOk().ifPresent(m -> map.computeIfAbsent(wkName, w -> new ArrayList<>()).add(m));

      current = tested.getNok().orElse(null);
      if (current == null) {
        break;
      }
    }
    if (current != null) {
      map.computeIfAbsent(fallbackWorkflowName, w -> new ArrayList<>()).add(current);
    }
    return map;
  }

  public static Workflow parse(String line) {
    final var tokens = line.split("[{,}]");
    final var name = tokens[0];
    final var dispatchers = IntStream.range(1, tokens.length - 1)
        .mapToObj(i -> Dispatcher.parse(tokens[i]))
        .toList();
    final var fallback = tokens[tokens.length - 1];
    return new Workflow(name, dispatchers, fallback);
  }
}
