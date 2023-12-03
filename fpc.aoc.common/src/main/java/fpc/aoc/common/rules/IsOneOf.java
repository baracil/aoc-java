package fpc.aoc.common.rules;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Set;

/**
 * a rule that checks that its input is one of the provided values
 * and returns its input
 */
@RequiredArgsConstructor
public class IsOneOf implements Rule<String,String> {

    public static @NonNull IsOneOf these(@NonNull String... expectedValues) {
        return new IsOneOf(Set.of(expectedValues));
    }

    private final @NonNull Set<String> expectedValues;

    @Override
    public @NonNull Validation<String> validate(@NonNull String input) {
        if (expectedValues.contains(input)) {
            return Validation.valid(input);
        }
        return Validation.invalid();
    }
}
