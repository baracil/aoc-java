package fpc.aoc.year2021.day19;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2021.day19.struct.Report;
import fpc.aoc.year2021.day19.struct.ReportCollector;

import java.util.List;

public abstract class Day19Solver extends SmartSolver<List<Report>> {

  @Override
  protected Converter<List<Report>> getConverter() {
    return s -> s.stream().collect(ReportCollector.COLLECTOR);
  }
}
