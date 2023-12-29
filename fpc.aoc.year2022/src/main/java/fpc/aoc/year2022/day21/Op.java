package fpc.aoc.year2022.day21;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Ratio;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class Op {
    Ratio constant;
    Ratio factor;

    public Op multiply(Op op) {
        if (op.factor.isNil()) {
            return new Op(constant.multiply(op.constant), factor.multiply(op.constant));
        } else if (this.factor.isNil()) {
            return new Op(op.constant.multiply(this.constant), op.factor.multiply(this.constant));
        }
        throw new AOCException("Op multiplication not implemented");
    }

    public Op divide(Op op) {
        if (op.factor.isNil()) {
            return new Op(constant.divide(op.constant), factor.divide(op.constant));
        } else if (this.factor.isNil()) {
            return new Op(op.constant.divide(this.constant), op.factor.divide(this.constant));
        }
        throw new AOCException("Op division not implemented");
    }

    public Op add(Op op) {
        return new Op(constant.add(op.constant), factor.add(op.factor));
    }

    public Op subtract(Op op) {
        return new Op(constant.subtract(op.constant), factor.subtract(op.factor));
    }

    public Ratio toGetZero() {
        return constant.negate().divide(factor);
    }
}
