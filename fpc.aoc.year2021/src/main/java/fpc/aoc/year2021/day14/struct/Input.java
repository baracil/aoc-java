package fpc.aoc.year2021.day14.struct;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public record Input(@NonNull String template, @NonNull Rules rules) {

  public static final Collector<String, ?, Input> COLLECTOR = Collector.of(Acc::new, Acc::addLine, Acc::combine, Acc::build);

  private static class Acc {
    private String template;
    private boolean inRules;
    private List<String> ruleLines = new ArrayList<>();

    public void addLine(@NonNull String line) {
      if (line.isBlank()) {
        inRules = true;
        return;
      }
      if (inRules) {
        ruleLines.add(line);
      } else {
        template = line;
      }
    }

    public @NonNull Acc combine(@NonNull Acc other) {
      throw new UnsupportedOperationException();
    }

    public @NonNull Input build() {
      final var rules = this.ruleLines.stream()
          .map(InsertionRule::parse)
          .collect(Rules.COLLECTOR);
      return new Input(template, rules);
    }
  }
}
