package fpc.aoc.year2019.day22._private;

import fpc.aoc.common.AOCException;
import lombok.NonNull;

import java.math.BigInteger;

/**
 * @author Bastien Aracil
 **/
public class BaseMath {

    private static final BaseMath BASE_MATH_10007 = new BaseMath(10007L);
    private static final BaseMath BASE_MATH_119_315_717_514_047L = new BaseMath(119_315_717_514_047L);

    @NonNull
    public static BaseMath create(long base) {
        if (base == 10007L) {
            return BASE_MATH_10007;
        } else if (base == 119_315_717_514_047L) {
            return BASE_MATH_119_315_717_514_047L;
        } else {
            return new BaseMath(base);
        }
    }

    private final long base;

    @NonNull
    private final BigInteger bigBase;

    private BaseMath(long base) {
        this.base = base;
        this.bigBase = BigInteger.valueOf(base);
    }

    public long modOfProduct(long v1, long v2) {
        final BigInteger bv1 = BigInteger.valueOf(v1);
        final BigInteger bv2 = BigInteger.valueOf(v2);
        return bv1.multiply(bv2).mod(bigBase).longValue();
    }

    public long mod(long value) {
        final long result = value%base;
        if (result<0) {
            return base+result;
        }
        return result;
    }

    public long invert(long value) {
        try {
            return doInvert(mod(value));
        } catch (AOCException e) {
            throw new AOCException("Could not invert value '"+value+"' in base "+base,e);
        }
    }

    private long doInvert(long value) {
        if (value == 1) {
            return 1;
        } else if (value==0) {
            throw new AOCException("Invalid value. 0 cannot be inverted");
        } else if (value<0) {
            return mod(-doInvert(-value));
        } else {
            final long q = base/value;
            final long r = base%value;

            return modOfProduct(q,(base - doInvert(r)));
        }
    }

    public long pow(long value, long power) {
        return doPow(mod(value),power);
    }

    private long doPow(long value, long power) {
        final BigInteger bValue = BigInteger.valueOf(value);
        final BigInteger bPower = BigInteger.valueOf(power);
        return bValue.modPow(bPower,bigBase).longValue();
    }
}
