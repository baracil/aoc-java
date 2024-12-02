package fpc.aoc.api;

public record SolverId(Year year,
                       Day day,
                       Part part) implements Comparable<SolverId> {


  public DayId dayId() {
    return new DayId(year, day);
  }

  @Override
  public int compareTo(SolverId o) {
    int result = this.year.compareTo(o.year);
    if (result == 0) {
      result = this.day.compareTo(o.day);
    }
    if (result == 0) {
      result = this.part.compareTo(o.part);
    }
    return result;
  }

  public boolean matches(Year year) {
    return this.year == year;
  }

  public boolean matches(DayId dayId) {
    return dayId.matches(this.year, this.day);
  }
}
