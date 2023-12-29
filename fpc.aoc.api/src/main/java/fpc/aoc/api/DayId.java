package fpc.aoc.api;

public record DayId(Year year, Day day) implements Comparable<DayId> {

  @Override
  public int compareTo(DayId o) {
    var result = this.year.compareTo(o.year);
    if (result == 0) {
      result = this.day.compareTo(o.day);
    }
    return result;
  }

  public boolean matches(Year year, Day day) {
    return this.year == year && this.day == day;
  }
}
