package fpc.aoc.year2021.day10.structures;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CompleterChecker {
    INSTANCE,
    ;

    public static CompleterChecker create() {
        return INSTANCE;
    }

    private static final BigInteger FIVE = BigInteger.valueOf(5);

    private static final Map<Character, Character> OPENING_CHAT = Map.of(
            '(', ')',
            '[', ']',
            '{', '}',
            '<', '>'
    );
    private static final Map<Character, BigInteger> SCORE_TABLE = Map.of(
            ')', BigInteger.valueOf(1),
            ']', BigInteger.valueOf(2),
            '}', BigInteger.valueOf(3),
            '>', BigInteger.valueOf(4));

    public Optional<BigInteger> complete(@NonNull String line) {
        final Deque<Character> pile = new ArrayDeque<>(line.length());

        for (int i = 0; i < line.length(); i++) {
            final var c = line.charAt(i);
            final var closingChar = OPENING_CHAT.get(c);

            if (closingChar == null) {
                final var lastOpening = pile.isEmpty() ? ' ' : pile.removeLast();
                if (lastOpening != c) {
                    return Optional.empty();
                }
            } else {
                pile.addLast(closingChar);
            }
        }

        BigInteger score = BigInteger.ZERO;
        while (!pile.isEmpty()) {
            score = score.multiply(FIVE).add(SCORE_TABLE.get(pile.removeLast()));
        }

        return Optional.of(score);
    }


}
