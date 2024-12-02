package fpc.aoc.year2020.day16;

import fpc.aoc.api.Solver;
import fpc.aoc.common.AOCException;

import java.util.Map;

public class Day16Part2Solver extends Day16Solver {

  public static Solver provider() {
    return new Day16Part2Solver();
  }

  @Override
  public Long doSolve(Input input) {
    final var matcher = new FieldsMatcher(input.fields());

    for (Ticket ticket : input.allTickets()) {
      matcher.testTicket(ticket);
    }

    matcher.cleanUp();

    final var mapping = matcher.getSolution().orElseThrow(() -> new AOCException("Not solved yet!"));

    final var myTicket = input.myTicket();

    return mapping.entrySet()
        .stream()
        .filter(e -> e.getKey().nameStartsWith("departure"))
        .mapToInt(Map.Entry::getValue)
        .map(myTicket::getValueAt)
        .mapToLong(i -> i)
        .reduce(1, (i1, i2) -> i1 * i2);

  }

}
