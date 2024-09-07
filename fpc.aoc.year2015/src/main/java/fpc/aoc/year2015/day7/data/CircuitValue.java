package fpc.aoc.year2015.day7.data;

import lombok.RequiredArgsConstructor;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@RequiredArgsConstructor
public class CircuitValue {

  private final Circuit circuit;
  private final Map<String,Long> values = new HashMap<>();

  public long get(String wire) {
    final var v = values.get(wire);
    if (v!=null) {
      return v;
    }
    return this.compute(wire);
  }

  public void resetAndSetTob(long value) {
    values.clear();
    values.put("b",value);
  }

  private long compute(String wire) {
    Deque<Operator> needed = new LinkedList<>();
    needed.addFirst(circuit.getOperatorByOutput(wire));

    while(!needed.isEmpty()) {
      final var op = needed.peek();
      final var value = op.evaluate(values);
      if (value == null) {
        op.missingInputNames(values)
          .map(circuit::getOperatorByOutput)
          .forEach(needed::addFirst);
      } else {
        needed.removeFirst();
        values.put(op.output(),value);
      }
    }

    return values.get(wire);
  }


}
