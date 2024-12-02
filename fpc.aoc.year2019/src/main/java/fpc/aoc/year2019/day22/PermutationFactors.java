package fpc.aoc.year2019.day22;

import fpc.aoc.year2019.day22._private.BaseMath;
import lombok.Getter;
import lombok.NonNull;

/**
 * @author Bastien Aracil
 **/
public class PermutationFactors {

    private final BaseMath baseMath;

    @Getter
    private final long size;

    @Getter
    private final long factor;

    @Getter
    private final long offset;

    public PermutationFactors(long size, long factor, long offset) {
        this.baseMath = BaseMath.create(size);
        this.size = size;
        this.factor = baseMath.mod(factor);
        this.offset = baseMath.mod(offset);
    }

    public long permute(long position) {
        return baseMath.mod(offset+baseMath.modOfProduct(position,factor));
    }

    @NonNull
    public PermutationFactors then(PermutationFactors after) {
        assert size == after.size;
        final long composedFactor = baseMath.modOfProduct(after.factor,this.factor);
        final long composedOffset = baseMath.modOfProduct(after.factor,this.offset)+after.offset;
        return new PermutationFactors(size,composedFactor,composedOffset);
    }

    @NonNull
    public PermutationFactors invert() {
        final long iFactor = baseMath.invert(factor);
        final long iOffset = baseMath.modOfProduct(-iFactor,offset);
        return new PermutationFactors(size, iFactor, iOffset);
    }

    @NonNull
    public PermutationFactors pow(long power) {
        final long powerFactor;
        final long powerOffset;
        if (factor == 1) {
            powerFactor = 1;
            powerOffset = baseMath.modOfProduct(power,offset);
        } else {
            final long iFactorMinus1 = baseMath.invert(factor-1);
            final long fixPoint = baseMath.modOfProduct(-offset,iFactorMinus1);

            powerFactor = baseMath.pow(factor,power);
            powerOffset = baseMath.mod(fixPoint - baseMath.modOfProduct(powerFactor,fixPoint));
        }
        return new PermutationFactors(size, powerFactor, powerOffset);
    }

    @NonNull
    public static PermutationFactors identity(long size) {
        return new PermutationFactors(size,1,0);
    }


}
