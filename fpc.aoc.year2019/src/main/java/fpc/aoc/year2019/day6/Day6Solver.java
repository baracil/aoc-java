package fpc.aoc.year2019.day6;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2019.day6._private.MutableOrbitMap;

import java.util.stream.Stream;

public abstract class Day6Solver extends SmartSolver<Stream<Relationship>> {


  @Override
  protected Converter<Stream<Relationship>> getConverter() {
    return l -> l.stream().map(Relationship::parse);
  }

  @Override
  protected Object doSolve(Stream<Relationship> input) {
    final MutableOrbitMap map = new MutableOrbitMap();
    input.forEach(map::addRelationShip);
    return solve(map);
  }


  protected abstract int solve(OrbitMap map);


}
