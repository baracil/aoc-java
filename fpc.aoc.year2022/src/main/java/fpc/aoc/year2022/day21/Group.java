package fpc.aoc.year2022.day21;

import fpc.aoc.common.AOCException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@RequiredArgsConstructor
public class Group {

  private final Map<String, Monkey> monkeys;


  public <T> T getRootValue(@NonNull MonkeyEvaluator<T> evaluator) {
    final Deque<String> toEvaluate = new LinkedList<>();
    final Map<String, T> knownValues = new HashMap<>();

    toEvaluate.add("root");
    while (true) {
      final var n = toEvaluate.pollFirst();
      if (n == null) {
        break;
      }
      final var monkey = monkeys.get(n);
      final T value;
      if (monkey instanceof Monkey.NumberYeller ny) {
        value = evaluator.getValue(ny);
      } else if (monkey instanceof Monkey.OperationYeller oy) {
        final var n1 = oy.n1();
        final var n2 = oy.n2();
        final var v1 = knownValues.get(n1);
        final var v2 = knownValues.get(n2);
        value = evaluator.getValue(oy, v1, v2);
        if (value == null) {
          toEvaluate.addFirst(n);
          toEvaluate.addFirst(n1);
          toEvaluate.addFirst(n2);
        }
      } else {
        throw new AOCException("Unknown monkey type");
      }
      if (value != null) {
        knownValues.put(n, value);
        if (n.equals("root")) {
          return value;
        }
      }
    }
    return knownValues.get("root");
  }


}
