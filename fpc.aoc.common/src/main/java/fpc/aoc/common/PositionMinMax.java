package fpc.aoc.common;

import fpc.aoc.common._private.PositionMinMaxAgg;

import java.util.stream.Collector;

public record PositionMinMax(int minX, int maxX, int minY, int maxY) {

  public static final Collector<Position, ?, PositionMinMax> COLLECTOR = Collector.of(PositionMinMaxAgg::new, PositionMinMaxAgg::add, PositionMinMaxAgg::combine, PositionMinMaxAgg::build);

}
