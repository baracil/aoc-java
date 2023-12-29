package fpc.aoc.year2023.day03;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.GridHelper;
import fpc.aoc.common.Position;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Schematic {

  private final ArrayOfChar input;
  private final Map<Position, Integer> pointers;
  private final List<Integer> numbers;
  private final List<Position> symbols;

  private final GridHelper helper;

  public Schematic(ArrayOfChar input, Map<Position, Integer> pointers, List<Integer> numbers, List<Position> symbols) {
    this.input = input;
    this.pointers = pointers;
    this.numbers = numbers;
    this.symbols = symbols;
    this.helper = GridHelper.create(input.width(), input.height());
  }

  public IntStream numberCloseToSymbol() {
    return symbols.stream()
        .flatMap(this::getIndicesAround)
        .mapToInt(numbers::get);
  }

  public LongStream gearRatio() {

    return symbols
        .stream()
        .filter(p -> input.get(p) == '*')
        .map(p -> getIndicesAround(p).mapToLong(numbers::get).toArray())
        .filter(a -> a.length == 2)
        .mapToLong(i -> i[0] * i[1]);
  }

  private Stream<Integer> getIndicesAround(Position p) {
    return helper.allAdjacentPosition(p)
        .map(pointers::get)
        .filter(Objects::nonNull)
        .distinct();
  }

  public static Schematic from(List<String> lines) {
    final var input = ArrayOfChar.from(lines, '.');

    final Map<Position, Integer> pointers = new HashMap<>();
    final List<Integer> numbers = new ArrayList<>();
    final List<Position> symbols = new ArrayList<>();

    final var width = input.width();
    final var height = input.height();
    int n;
    for (int h = 0; h < height; h++) {
      int w = 0;
      n = 0;
      int s = -1;
      while (w <= width) {
        final var c = w == width ? '.' : input.get(w, h);
        switch (c) {
          case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
            if (s < 0) {
              s = w;
            }
            n = n * 10 + (c - '0');
          }
          default -> {
            if (s >= 0) {
              for (int i = s; i < w; i++) {
                pointers.put(Position.of(i, h), numbers.size());
              }
              numbers.add(n);
            }
            s = -1;
            n = 0;
            if (c != '.') {
              symbols.add(Position.of(w, h));
            }
          }
        }
        w++;
      }
    }

    return new Schematic(input, pointers, numbers, symbols);
  }
}
