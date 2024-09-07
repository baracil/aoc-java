package fpc.aoc.year2019.day10;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2019.day10.computation.AsteroidField;
import fpc.aoc.year2019.day10.computation.SpaceMap;
import fpc.aoc.year2019.day10.computation.Type;
import lombok.NonNull;

import java.util.stream.Collectors;

/**
 * @author Bastien Aracil
 **/
public abstract class Day10Solver extends SmartSolver<AsteroidField> {


  @Override
  protected @NonNull Converter<AsteroidField> getConverter() {
    return l -> l.stream()
        .collect(
            Collectors.collectingAndThen(
                SpaceMap.collector(Type::getType),
                AsteroidField::new
            ));
  }

}
