package fpc.aoc.year2024.day05;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collector;

@RequiredArgsConstructor
@Getter
public class Problem {
  private final Contraints constraints;
  private final List<Update> updates;



  public static Collector<String, ?, Problem> COLLECTOR = Collector.of(Agg::new, Agg::addLine, Agg::combine, Agg::build);


  private static class Agg {

    private final Map<PageNumber,Set<PageNumber>> constraints = new HashMap<>();
    private final List<Update> updates = new ArrayList<>();

    public void addLine(String line) {
      if (line.isEmpty()) {
        return;
      }
      String[] token = line.split("[|,]");
      if (token.length == 2) {
        this.constraints.computeIfAbsent(PageNumber.from(token[0]), _ -> new HashSet<>()).add(PageNumber.from(token[1]));
      } else {
        final var pages = Arrays.stream(token).map(PageNumber::from).toList();
        updates.add(new Update(pages));
      }
    }

    public Agg combine(Agg other) {
      this.constraints.putAll(other.constraints);
      this.updates.addAll(other.updates);
      return this;
    }

    public Problem build() {
      return new Problem(new Contraints(this.constraints), updates);
    }

  }
}
