package fpc.aoc.year2020.day2.structures;

import lombok.NonNull;
import lombok.Value;

@Value
public class NewRule implements Rule{
    int firstPosition;
    int secondPosition;
    char character;

    public static @NonNull NewRule parse(@NonNull String ruleAsString) {
        final String[] token = ruleAsString.split("[- ]",3);
        return new NewRule(
                Integer.parseInt(token[0])-1,
                Integer.parseInt(token[1])-1,
                token[2].charAt(0)
        );
    }

    @Override
    public boolean isPasswordValid(@NonNull Password password) {
        final var charAtFirstPosition = password.getCharAt(firstPosition);
        final var charAtSecondPosition = password.getCharAt(secondPosition);
        return (charAtFirstPosition==character) != (charAtSecondPosition==character);
    }
}
