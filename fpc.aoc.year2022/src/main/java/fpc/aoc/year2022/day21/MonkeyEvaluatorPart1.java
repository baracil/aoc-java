package fpc.aoc.year2022.day21;

public class MonkeyEvaluatorPart1 implements MonkeyEvaluator<Long> {

    @Override
    public Long getValue(Monkey.NumberYeller monkey) {
        return monkey.value();
    }

    @Override
    public Long getValue(Monkey.OperationYeller monkey, Long value1, Long value2) {
        return monkey.operator().apply(value1,value2);
    }
}
