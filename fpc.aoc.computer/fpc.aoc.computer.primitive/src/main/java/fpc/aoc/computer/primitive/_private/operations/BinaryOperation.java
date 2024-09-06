package fpc.aoc.computer.primitive._private.operations;

import fpc.aoc.computer.primitive._private.ExecutionContext;
import lombok.NonNull;

import java.util.function.LongBinaryOperator;

public class BinaryOperation extends SequentialOperation {

    @NonNull
    private final LongBinaryOperator operator;

    public BinaryOperation(@NonNull LongBinaryOperator operator) {
        super(3);
        this.operator = operator;
    }

    @Override
    public void doPerform(@NonNull ExecutionContext context) {
        final long p0 = context.getParameter(0);
        final long p1 = context.getParameter(1);
        final long result = operator.applyAsLong(p0,p1);
        context.setParameter(2,result);
    }
}
