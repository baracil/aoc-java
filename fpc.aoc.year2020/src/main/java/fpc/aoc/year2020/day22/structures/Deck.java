package fpc.aoc.year2020.day22.structures;

import lombok.NonNull;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class Deck {

  List<Integer> cards;

  public int firstCard() {
    return cards.getFirst();
  }

  public @NonNull Deck newDeckIfLostRound() {
    return new Deck(cards.subList(1, cards.size()));
  }

  public @NonNull Deck newDeckIfWonRound(int cardOfLooser) {
    final List<Integer> card = new ArrayList<>(cards.subList(1, cards.size()));
    card.add(firstCard());
    card.add(cardOfLooser);
    return new Deck(card);
  }

  public boolean canRecurse() {
    return firstCard() <= (cards.size() - 1);
  }

  public @NonNull Deck createSubDeck() {
    assert canRecurse();
    return new Deck(cards.subList(1, 1 + firstCard()));
  }


  public boolean hasNoCard() {
    return cards.isEmpty();
  }

  public @NonNull Score score() {
    return new Score(cards);
  }

  @Override
  public String toString() {
    return cards.toString();
  }
}
