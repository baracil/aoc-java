package fpc.aoc.year2019.day22._private;

import fpc.aoc.common.AOCException;
import fpc.aoc.year2019.day22.PermutationFactors;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Bastien Aracil
 **/
@RequiredArgsConstructor
public class ShuffleTechniqueParser {

    private final long size;

    @NonNull
    public PermutationFactors identity() {
        return PermutationFactors.identity(size);
    }

    @NonNull
    public PermutationFactors parse(@NonNull String line) {
        if (line.equals("deal into new stack")) {
            return dealToNewStack();
        } else if (line.startsWith("deal with increment ")) {
            final long increment = Long.parseLong(line.split(" ")[3]);
            return dealWithIncrement(increment);
        } else if (line.startsWith("cut")) {
            final long cutPosition = Long.parseLong(line.split(" ")[1]);
            return cut(cutPosition);
        } else {
            throw new AOCException("Could not parse line '" + line + "'");
        }
    }



    @NonNull
    private PermutationFactors dealToNewStack() {
        return new PermutationFactors(size,-1,-1);
    }

    @NonNull
    private PermutationFactors dealWithIncrement(long increment) {
        return new PermutationFactors(size,increment,0);
    }
    @NonNull
    private PermutationFactors cut(long cutPosition) {
        return new PermutationFactors(size,1,-cutPosition);
    }
}
