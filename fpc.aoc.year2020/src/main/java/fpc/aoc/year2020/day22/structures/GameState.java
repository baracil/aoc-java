package fpc.aoc.year2020.day22.structures;

import fpc.aoc.common.AOCException;
import lombok.NonNull;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

@Value
public class GameState {

    @NonNull Deck player1;

    @NonNull Deck player2;

    public int firstCardOf(@NonNull Player player) {
        return getDeck(player).firstCard();
    }

    public @NonNull Deck getDeck(@NonNull Player player) {
        return switch (player) {
            case ONE -> player1;
            case TWO -> player2;
        };
    }

    /**
     * @return an optional containing the sub game if both players can recurse their decks
     */
    public @NonNull Optional<GameState> subGameState() {
        if (player1.canRecurse() && player2.canRecurse()) {
            return Optional.of(new GameState(player1.createSubDeck(), player2.createSubDeck()));
        }
        return Optional.empty();
    }

    /**
     * @return the next game state if the winner is the one provided
     */
    public @NonNull GameState nextState(@NonNull Player winner) {
        return switch (winner) {
            case ONE -> new GameState(player1.newDeckIfWonRound(player2.firstCard()), player2.newDeckIfLostRound());
            case TWO -> new GameState(player1.newDeckIfLostRound(), player2.newDeckIfWonRound(player1.firstCard()));
        };
    }

    public boolean isDone() {
        return player1.hasNoCard() || player2.hasNoCard();
    }

    public @NonNull GameOutcome outcome() {
        final var winner = getGameWinner();
        return new GameOutcome(winner, getDeck(winner).score());
    }

    public @NonNull Player getGameWinner() {
        if (player1.hasNoCard()) {
            return Player.TWO;
        }
        else if (player2.hasNoCard()) {
            return Player.ONE;
        }
        throw new AOCException("Invalid state to get winner");

    }

    public static @NonNull GameState parse(@NonNull List<String> lines) {
        final List<Integer> card1 = new ArrayList<>();
        final List<Integer> card2 = new ArrayList<>();
        final Function<List<Integer>, Consumer<String>> setterFactory = queue -> s -> queue.add(Integer.parseInt(s));
        Consumer<String> setter = null;
        for (String line : lines) {
            if (line.isBlank()) {
                setter = null;
            } else if (line.startsWith("Player 1:")) {
                setter = setterFactory.apply(card1);
            } else if (line.startsWith("Player 2:")) {
                setter = setterFactory.apply(card2);
            } else {
                assert setter != null;
                setter.accept(line);
            }
        }
        return new GameState(new Deck(card1), new Deck(card2));
    }

}
