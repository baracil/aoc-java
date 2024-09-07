package fpc.aoc.year2019.day22._private;

import fpc.aoc.year2019.day22.Deck;
import fpc.aoc.year2019.day22.PermutationFactors;
import lombok.NonNull;

/**
 * @author Bastien Aracil
 **/
public class DeckWithPermutationShuffle implements Deck {

    @NonNull
    private final PermutationFactors permutation;

    @NonNull
    private final PermutationFactors invertedPermutation;

    public DeckWithPermutationShuffle(@NonNull PermutationFactors permutation) {
        this.permutation = permutation;
        this.invertedPermutation = permutation.invert();
    }

    @Override
    public long cardAtPosition(long position) {
        return invertedPermutation.permute(position);
    }

    @Override
    public long positionOfCard(long card) {
        return permutation.permute(card);
    }
}
