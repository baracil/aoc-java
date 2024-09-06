package fpc.aoc.year2019.day16;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Signal {

    public Signal(@NonNull String signal) {
        this.values = signal.chars().map(c -> c-'0').toArray();
        this.offset = 0;
    }

    @NonNull
    private final int[] values;

    private final int offset;

    @NonNull
    public Signal duplicate(int nbTimes) {
        final int size = values.length;
        final int[] signal = new int[size*nbTimes];

        for (int i = 0; i < signal.length; i++) {
            signal[i] = values[i%size];
        }
        return new Signal(signal,offset);
    }

    @NonNull
    public Signal truncate(int offset) {
        if (offset<=0) {
            return this;
        }
        return new Signal(values,this.offset+offset);
    }

    @NonNull
    public String getFirstEightDigits() {
        return getFirstNthDigits(8);
    }

    @NonNull
    public String getFirstSeventhDigits() {
        return getFirstNthDigits(7);
    }

    private String getFirstNthDigits(int nb) {
        return Arrays.stream(values,offset,offset+nb).mapToObj(i -> ""+i).collect(Collectors.joining());
    }

    @NonNull
    public Signal applyFFT() {
        return applyFFT(1);
    }

    @NonNull
    public Signal applyFFT(int nbTimes) {
        int[] input = values.clone();
        int[] output = new int[values.length];

        final int N = values.length;
        final int pminInclusive = (int)Math.ceil(Math.sqrt(N+1.25)-0.5);
        final int maxGroup = (int)Math.floor((N +1.)/(pminInclusive));

        final boolean[] groupPositivity = createGroupFactors(maxGroup);

        for (int t = 0; t < nbTimes; t++) {
            computeOneStep(input, output, pminInclusive, groupPositivity);
            int[] aux = output;
            output = input;
            input = aux;

        }
        return new Signal(input,offset);
    }

    private boolean[] createGroupFactors(int maxGroup) {
        final boolean[] result = new boolean[maxGroup];
        for (int i = 0; i < maxGroup; i++) {
            boolean positive = 0 == (i + 1) / 2 % 2;
            result[i] = positive;
        }
        return result;
    }

    private static final int[] BASE_PATTERN = {0,1,0,-1};

    public int getFactor(int i, int p) {
        return BASE_PATTERN[((i+1)/p)&3];
    }

    public void computeOneStep(int[] input, int[] output, int fastLimit, boolean[] groupPositivity) {
        final int size = input.length;


        {
            int result = input[size - 1];
            output[size - 1] = getDigit(result);

            for (int pos = size - 1; pos >= Math.max(offset+1,fastLimit); pos--) {
                for (int g = 0, dg = pos - 1, fg = pos - 1; dg < size; g++, dg += pos, fg += pos+1) {
                    if (groupPositivity[g]) {
                        for (int i = dg; i <= fg && i < size; i++) {
                            result += input[i];
                        }
                    } else {
                        for (int i = dg; i <= fg && i < size; i++) {
                            result -= input[i];
                        }
                    }
                }
                output[pos - 1] = getDigit(result);
            }
        }

        {
            IntStream.range(offset+1,fastLimit)
                     .parallel()
                     .forEach(pos -> computeSlow(input, output, pos));
        }
    }

    private void computeSlow(int[] data, int[] output, int pos) {
        int result = 0;
        for (int j = 0; j < data.length; j++) {
            int fct = getFactor(j, pos);
            result += data[j] * fct;
        }
        output[pos-1] = getDigit(result);
    }

    private int getDigit(long val) {
        return (int)(Math.abs(val)%10);
    }


}
