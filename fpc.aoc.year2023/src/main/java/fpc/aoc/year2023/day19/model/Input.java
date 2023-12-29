package fpc.aoc.year2023.day19.model;

import fpc.aoc.common.Pair;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collector;

@RequiredArgsConstructor
public class Input {

  private final Map<String, Workflow> workflowByName;
  @Getter
  private final List<Scrap> scraps;


  public String process(Scrap scrap) {
    var name = "in";
    while (!name.equals("A") && !name.equals("R")) {
      name = workflowByName.get(name).process(scrap);
    }
    return name;
  }

  public List<MultiScrap> process(MultiScrap multiScrap) {
    final List<Pair<String, MultiScrap>> toProcess = new LinkedList<>();
    final List<MultiScrap> accepted = new ArrayList<>();

    toProcess.add(Pair.of("in", multiScrap));

    while (!toProcess.isEmpty()) {
      final var pair = toProcess.removeFirst();

      final var wk = workflowByName.get(pair.first());
      final var result = wk.process(pair.second());

      for (Map.Entry<String, List<MultiScrap>> entry : result.entrySet()) {
        final var wkName = entry.getKey();
        switch (wkName) {
          case "A" -> accepted.addAll(entry.getValue());
          case "R" -> {
          }
          default -> entry.getValue().stream().map(w -> Pair.of(wkName, w)).forEach(toProcess::add);
        }
      }
    }

    return accepted;

  }


  public static final Collector<String, ?, Input> COLLECTOR = Collector.of(Agg::new, Agg::add, Agg::combine, Agg::build);

  private static class Agg {

    private final Map<String, Workflow> workflowMap = new HashMap<>();
    private final List<Scrap> scraps = new ArrayList<>();

    private boolean inWorkflow = true;

    public void add(String line) {
      if (line.isEmpty()) {
        inWorkflow = false;
        return;
      }
      if (inWorkflow) {
        final var workflow = Workflow.parse(line);
        workflowMap.put(workflow.name(), workflow);
      } else {
        final var scrap = Scrap.parse(line);
        this.scraps.add(scrap);
      }
    }

    public Agg combine(Agg agg) {
      throw new UnsupportedOperationException();
    }

    public Input build() {
      return new Input(workflowMap, scraps);
    }

  }


}
