package fpc.aoc.year2015.day7.data;

import fpc.aoc.common.AOCException;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public sealed interface Operator {

  String output();

  Long evaluate(Map<String, Long> values);

  Stream<Operand> inputOperands();


  long MASK = 0xFFFFFFFFL;

  default Stream<String> missingInputNames(Map<String, Long> values) {
    return inputOperands()
      .map(Operand::name)
      .filter(Objects::nonNull)
      .filter(not(values::containsKey));
  }


  record Setter(Operand value, String output) implements Operator {
    @Override
    public Long evaluate(Map<String, Long> values) {
      return value.get(values);
    }

    @Override
    public Stream<Operand> inputOperands() {
      return Stream.of(value);
    }
  }

  record And(Operand input1, Operand input2, String output) implements Operator {
    @Override
    public Long evaluate(Map<String, Long> values) {
      final var l1 = input1.get(values);
      final var l2 = input2.get(values);
      if (l1 == null || l2 == null) {
        return null;
      }
      return l1 & l2;
    }

    @Override
    public Stream<Operand> inputOperands() {
      return Stream.of(input1, input2);
    }
  }

  record LShift(Operand input, int shift, String output) implements Operator {
    @Override
    public Long evaluate(Map<String, Long> values) {
      final var l1 = input.get(values);
      if (l1 == null) {
        return null;
      }
      return (l1 << shift) & MASK;
    }

    @Override
    public Stream<Operand> inputOperands() {
      return Stream.of(input);
    }
  }

  record RShift(Operand input, int shift, String output) implements Operator {
    @Override
    public Long evaluate(Map<String, Long> values) {
      final var l1 = input.get(values);
      if (l1 == null) {
        return null;
      }
      return l1 >> shift;
    }

    @Override
    public Stream<Operand> inputOperands() {
      return Stream.of(input);
    }

  }

  record Or(Operand input1, Operand input2, String output) implements Operator {
    @Override
    public Long evaluate(Map<String, Long> values) {
      final var l1 = input1.get(values);
      final var l2 = input2.get(values);
      if (l1 == null || l2 == null) {
        return null;
      }
      return l1 | l2;
    }

    @Override
    public Stream<Operand> inputOperands() {
      return Stream.of(input1, input2);
    }
  }

  record Not(Operand input, String output) implements Operator {
    @Override
    public Long evaluate(Map<String, Long> values) {
      final var l1 = input.get(values);
      if (l1 == null) {
        return null;
      }
      return (~l1) & MASK;
    }

    @Override
    public Stream<Operand> inputOperands() {
      return Stream.of(input);
    }

  }


  static Operator parse(String line) {
    try {
      final var tokens = line.split(" ");

      if (tokens[1].equals("RSHIFT")) {
        return new RShift(Operand.parse(tokens[0]), Integer.parseInt(tokens[2]), tokens[4]);
      }

      if (tokens[1].equals("LSHIFT")) {
        return new LShift(Operand.parse(tokens[0]), Integer.parseInt(tokens[2]), tokens[4]);
      }

      if (tokens[1].equals("OR")) {
        return new Or(Operand.parse(tokens[0]), Operand.parse(tokens[2]), tokens[4]);
      }

      if (tokens[1].equals("AND")) {
        return new And(Operand.parse(tokens[0]), Operand.parse(tokens[2]), tokens[4]);
      }

      if (tokens[0].equals("NOT")) {
        return new Not(Operand.parse(tokens[1]), tokens[3]);
      }

      return new Setter(Operand.parse(tokens[0]), tokens[2]);
    } catch (Exception e) {
      throw new AOCException("Cannot parse line '" + line + "'", e);
    }
  }
}
