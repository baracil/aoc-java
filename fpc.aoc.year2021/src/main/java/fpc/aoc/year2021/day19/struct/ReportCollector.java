package fpc.aoc.year2021.day19.struct;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public class ReportCollector {

  public static final Collector<String, ReportCollector, List<Report>> COLLECTOR = Collector.of(
      ReportCollector::new,
      ReportCollector::accumulate,
      ReportCollector::combine,
      ReportCollector::build
  );

  private Report.ReportBuilder builder = null;
  private final List<Report> reports = new ArrayList<>();

  public void accumulate(@NonNull String line) {
    if (line.startsWith("---")) {
      this.finishBuilderIfAny();
      this.builder = new Report.ReportBuilder();
    } else if (!line.isBlank()) {
      builder.beacon(Vector.parse(line));
    }
  }


  public ReportCollector combine(@NonNull ReportCollector other) {
    throw new UnsupportedOperationException();
  }

  public List<Report> build() {
    this.finishBuilderIfAny();
    return reports;
  }

  private void finishBuilderIfAny() {
    if (builder != null) {
      reports.add(builder.build());
    }
    builder = null;
  }

}
