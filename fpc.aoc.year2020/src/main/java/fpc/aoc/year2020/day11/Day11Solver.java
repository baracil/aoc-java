package fpc.aoc.year2020.day11;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.GridHelper;
import fpc.aoc.common.SimpleGridHelper;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day11.structures.AdjacentCounter;
import fpc.aoc.year2020.day11.structures.SeatLayoutLife;
import fpc.aoc.year2020.day11.structures.StateEvolutionRule;

public abstract class Day11Solver extends SmartSolver<SeatLayoutLife> {

  @Override
  protected Converter<SeatLayoutLife> getConverter() {
    return Converter.TO_ARRAY_OF_CHAR.andThen(this::createSeatLayout);
  }

  private SeatLayoutLife createSeatLayout(ArrayOfChar chars) {
    final GridHelper gridHelper = new SimpleGridHelper(chars.width(), chars.height());
    return new SeatLayoutLife(gridHelper, createEvolutionRule(), createCounter(gridHelper), chars);
  }

  protected abstract AdjacentCounter createCounter(GridHelper gridHelper);

  protected abstract StateEvolutionRule createEvolutionRule();

  @Override
  public Long doSolve(SeatLayoutLife seatLayoutLife) {
    while (seatLayoutLife.evolving()) ;
    return seatLayoutLife.totalNumberOfOccupiedSeats();
  }

}
