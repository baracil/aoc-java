package fpc.aoc.input;

import fpc.aoc.api.*;
import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public abstract class SmartSolver<I> implements Solver {

  private static final Pattern DAY_PART = Pattern.compile("fpc\\.aoc\\.year(?<year>[0-9]+)\\..+\\.Day(?<day>[0-9]+)Part(?<part>[12]).+");

  private final SolverId id;

  public SmartSolver(Year year, Day day, Part part) {
    this.id = new SolverId(year, day, part);
  }

  public SmartSolver() {
    final Matcher matcher = DAY_PART.matcher(this.getClass().getName());
    if (!matcher.matches()) {
      throw new RuntimeException("Solver must provide DAY and PART by parameter or by having its class name of the form fpc.aoc.yearXXXX.*.DayYYParZ");
    }
    final var year = Year.parse(matcher.group("year"));
    final var day = Day.parse(matcher.group("day"));
    final var part = Part.parse(matcher.group("part"));

    this.id = new SolverId(year, day, part);
  }

  /**
   * @return the converter required to convert the input data of the problem to the required type
   */
  protected abstract Converter<I> getConverter();

  protected abstract Object doSolve(I input);

  @Override
  public Object solve(RawInput input) {
    final var converter = getConverter();
    return doSolve(converter.convert(input.read()));
  }

}
