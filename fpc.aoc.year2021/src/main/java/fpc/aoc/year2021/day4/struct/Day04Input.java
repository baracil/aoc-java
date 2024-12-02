package fpc.aoc.year2021.day4.struct;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

@RequiredArgsConstructor
public class Day04Input {

  private final List<Integer> numbers;
  private final List<Grid> grids;
  @Getter
  private final GridState gridState;


  public Optional<Day04Input> playOneRoundPart1() {
    if (numbers.isEmpty()) {
      return Optional.empty();
    }
    final var number = this.numbers.getFirst();
    final var numbers = this.numbers.stream().skip(1).toList();

    final var grids = this.grids.stream()
        .map(g -> g.pushOneNumber(number))
        .toList();

    final var state = grids.stream()
        .map(Grid::state)
        .filter(s -> s instanceof GridState.Winning)
        .findFirst()
        .orElse(gridState);

    return Optional.of(new Day04Input(numbers, grids, state));
  }

  public Optional<Day04Input> playOneRoundPart2() {
    if (numbers.isEmpty()) {
      return Optional.empty();
    }
    final var number = this.numbers.getFirst();
    final var numbers = this.numbers.stream().skip(1).toList();

    final var grids = this.grids.stream()
        .filter(g -> g.state() instanceof GridState.NotWinning)
        .map(g -> g.pushOneNumber(number))
        .toList();

    final var state = grids.stream()
        .map(Grid::state)
        .reduce((first, second) -> second instanceof GridState.Winning ? second : first).orElse(gridState);

    return Optional.of(new Day04Input(numbers, grids, state));
  }


  public static Collector<String, ?, Day04Input> COLLECTOR = Collector.of(Agglomerator::new,
      Agglomerator::accumulate,
      Agglomerator::combiner,
      Agglomerator::finisher
  );


  private static class Agglomerator {

    private List<Integer> numbers;
    private final List<Grid> grids = new ArrayList<>();
    private final List<String> gridRows = new ArrayList<>();

    public void accumulate(String line) {
      if (line.isEmpty()) {
        buildGrid();
        gridRows.clear();
      } else if (numbers == null) {
        numbers = Arrays.stream(line.split(","))
            .map(Integer::parseInt)
            .toList();
      } else {
        gridRows.add(line);
      }
    }

    public Agglomerator combiner(Agglomerator agglomerator) {
      throw new UnsupportedOperationException();
    }

    public Day04Input finisher() {
      buildGrid();
      return new Day04Input(numbers, List.copyOf(grids), new GridState.NotWinning());
    }

    private void buildGrid() {
      if (gridRows.isEmpty()) {
        return;
      }
      final var grid = Grid.from(gridRows);
      grids.add(grid);
    }
  }
}
