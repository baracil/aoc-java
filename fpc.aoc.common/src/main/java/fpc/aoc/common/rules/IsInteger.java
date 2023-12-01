package fpc.aoc.common.rules;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * A rule that check if the input string is an integer
 * and returns this integer
 */
@RequiredArgsConstructor
public class IsInteger implements Rule<String,Integer> {

    public static IsInteger create() {
        return new IsInteger();
    }

    @Override
    public @NonNull Validation<Integer> validate(@NonNull String input) {
        try {
            return Validation.valid(Integer.parseInt(input));
        } catch (NumberFormatException nfe) {
            return Validation.invalid();
        }
    }
}
