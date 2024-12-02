package fpc.aoc.year2022.day15;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

public abstract class Day15Solver extends SmartSolver<Report> {

  @Override
  protected Converter<Report> getConverter() {
    return Converter.forItem(SensorReport::parse).andThen(Report::new);
  }
}
