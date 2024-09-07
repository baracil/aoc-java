package fpc.aoc.year2015.day7.data;

import fpc.aoc.common.AOCException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class Circuit {

  private final Map<String, Operator> operators;

  public static Circuit create(List<Operator> operators) {
    final var map = operators.stream()
      .collect(Collectors.toMap(Operator::output, o -> o));

    return new Circuit(map);
  }

  public Operator getOperatorByOutput(String wire) {
    final var operator = operators.get(wire);
    if (operator == null) {
      throw new AOCException("Cannot find operator outputing '"+wire+"'");
    }
    return operator;
  }
}
