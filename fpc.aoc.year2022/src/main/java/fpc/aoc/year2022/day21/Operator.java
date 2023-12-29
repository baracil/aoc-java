package fpc.aoc.year2022.day21;

import fpc.aoc.common.AOCException;
import lombok.RequiredArgsConstructor;

import java.util.function.BinaryOperator;
import java.util.function.LongBinaryOperator;

@RequiredArgsConstructor
public enum Operator {
    ADD(Long::sum, Op::add),
    SUBTRACT((l1,l2) -> l1 - l2, Op::subtract),
    DIVIDE((l1,l2) -> l1/l2,Op::divide),
    MULTIPLE((l1,l2) -> l1*l2,Op::multiply),
    ;

    private final LongBinaryOperator longOperator;
    private final BinaryOperator<Op> opOperator;

    public Long apply(Long left, Long right) {
        if (left == null || right == null) {
            return null;
        }
        return longOperator.applyAsLong(left,right);
    }

    public Op apply(Op left, Op right) {
        if (left == null || right == null) {
            return null;
        }
        return opOperator.apply(left,right);
    }

    public static Operator parse(String line) {
        return switch (line) {
            case "+"  -> ADD;
            case "-" -> SUBTRACT;
            case "*" -> MULTIPLE;
            case "/" -> DIVIDE;
            default -> throw new AOCException("Not an operation "+line);
        };
    }
}
