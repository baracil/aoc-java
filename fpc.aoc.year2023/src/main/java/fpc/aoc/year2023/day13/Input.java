package fpc.aoc.year2023.day13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class Input {


  private final long[] rows;
  private final long[] cols;

  private Input(List<String> rows) {
    final int nbCols = rows.getFirst().length();

    this.rows = rows.stream().mapToLong(Input::rowToLong).toArray();
    this.cols = IntStream.range(0, nbCols).mapToLong(i -> colToLong(rows, i)).toArray();
  }


  public int compute(Checker checker) {
    int result = check(rows, checker);
    if (result >= 0) {
      return result * 100;
    }
    return check(cols, checker);
  }

  private int check(long[] lines, Checker checker) {
    final int nbLines = lines.length;
    for (int i = nbLines - 1; i > 0; i--) {
      if (checker.check(lines, 0, i)) {
        return (i + 1) / 2;
      }
    }

    for (int i = 0; i < nbLines - 1; i++) {
      if (checker.check(lines, i, nbLines - 1)) {
        return (i + nbLines + 1) / 2;
      }
    }

    return -1;
  }


  public static long rowToLong(String line) {
    long result = 0;
    for (int i = 0; i < line.length(); i++) {
      final var c = line.charAt(i);
      result = result * 2 + (c == '#' ? 1 : 0);
    }
    return result;
  }

  public static long colToLong(List<String> rows, int columnIdx) {
    long result = 0;
    for (String row : rows) {
      final var chr = row.charAt(columnIdx);
      result = result * 2 + (chr == '#' ? 1 : 0);
    }
    return result;
  }


  public static final Collector<String, ?, List<Input>> COLLECTOR = Collector.of(
      Agg::new,
      Agg::add,
      Agg::combine,
      Agg::build
  );

  private static class Agg {

    private List<String> lines = new ArrayList<>();
    private final List<Input> result = new ArrayList<>();

    public void add(String line) {
      if (line.isBlank()) {
        result.add(new Input(lines));
        lines = new ArrayList<>();
      } else {
        lines.add(line);
      }
    }

    public Agg combine(Agg agg) {
      throw new UnsupportedOperationException();
    }

    public List<Input> build() {
      if (!lines.isEmpty()) {
        result.add(new Input(lines));
        lines = new ArrayList<>();
      }
      return result;
    }

  }
}
