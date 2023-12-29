package fpc.aoc.year2022.day21;

import fpc.aoc.common.Ratio;

public class MonkeyEvaluatorPart2 implements MonkeyEvaluator<Op> {

  @Override
  public Op getValue(Monkey.NumberYeller monkey) {
    if (monkey.name().equals("humn")) {
      return new Op(Ratio.ZERO, Ratio.ONE);
    }
    return new Op(Ratio.from(monkey.value()), Ratio.ZERO);

  }

  @Override
  public Op getValue(Monkey.OperationYeller monkey, Op value1, Op value2) {
    return switch (monkey.name()) {
      case "humn" -> new Op(Ratio.ZERO, Ratio.ONE);
      case "root" -> Operator.SUBTRACT.apply(value1, value2);
      default -> monkey.operator().apply(value1, value2);
    };
  }
}
