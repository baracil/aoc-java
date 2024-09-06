package fpc.aoc.year2019.day22;

import fpc.aoc.year2019.day22._private.DeckWithPermutationShuffle;
import lombok.NonNull;

/**
 * @author perococco
 **/
public interface Deck {

    @NonNull
    static Deck factorySetting(long size) {
        return new DeckWithPermutationShuffle(PermutationFactors.identity(size));
    }

    static Deck shuffled(@NonNull PermutationFactors permutationFactors) {
        return new DeckWithPermutationShuffle(permutationFactors);
    }

    long cardAtPosition(long position);

    long positionOfCard(long card);
}
