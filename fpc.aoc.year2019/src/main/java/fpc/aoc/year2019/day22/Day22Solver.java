package fpc.aoc.year2019.day22;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2019.day22._private.DeckWithPermutationShuffle;
import fpc.aoc.year2019.day22._private.ShuffleTechniqueParser;
import lombok.NonNull;

public abstract class Day22Solver extends SmartSolver<Deck> {


    @Override
    protected @NonNull Converter<Deck> getConverter() {
        final long size = deckSize();
        final ShuffleTechniqueParser parser = new ShuffleTechniqueParser(size);

        return list -> {
            final var factors = list.stream().map(parser::parse)
                .reduce(PermutationFactors::then)
                .orElseGet(() -> PermutationFactors.identity(size));
          return (Deck) new DeckWithPermutationShuffle(factors.pow(numberOfRepetitions()));
        };
    }

    protected abstract Object doSolve(@NonNull Deck deck);

    protected abstract long deckSize();

    protected abstract long numberOfRepetitions();

}
