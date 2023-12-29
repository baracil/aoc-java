package fpc.aoc.year2020.day15;

import lombok.NonNull;

public class HistoryWithArray implements History {

    private final NumberHistory[] histories;

    public HistoryWithArray(int size) {
        this.histories = new NumberHistory[size+1];
    }

    @Override
    public @NonNull NumberHistory get(int lastSpoken) {
        return histories[lastSpoken];
    }

    @Override
    public void initialize(int[] initialNumbers) {
        for (int turn = 0; turn < initialNumbers.length; turn++) {
            final var nb = initialNumbers[turn];
            histories[nb] = new NumberHistory(nb,turn);
        }
    }

    @Override
    public void updateNumberHistory(int number, int turnIndex) {
        final NumberHistory nh = histories[number];
        if (nh == null) {
            histories[number] = new NumberHistory(number,turnIndex);
        } else {
            histories[number].setLastSpokenTurn(turnIndex);
        }
    }
}
