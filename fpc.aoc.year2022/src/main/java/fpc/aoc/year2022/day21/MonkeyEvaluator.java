package fpc.aoc.year2022.day21;

public interface MonkeyEvaluator<T> {

  T getValue(Monkey.NumberYeller monkey);

  T getValue(Monkey.OperationYeller monkey, T value1, T value2);
}
