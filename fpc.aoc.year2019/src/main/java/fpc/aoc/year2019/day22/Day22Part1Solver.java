package fpc.aoc.year2019.day22;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day22Part1Solver extends Day22Solver {

    public static Solver provider() {
        return new Day22Part1Solver();
    }

    @Override
    protected Object doSolve(@NonNull Deck deck) {
        return deck.positionOfCard(2019);
    }

    protected long deckSize() {
        return 10007L;
    }

    protected long numberOfRepetitions() {
        return 1L;
    }
}
