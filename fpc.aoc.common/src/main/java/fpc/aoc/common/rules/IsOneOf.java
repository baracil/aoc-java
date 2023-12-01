package fpc.aoc.common.rules;

import com.google.common.collect.ImmutableSet;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * a rule that checks that its input is one of the provided values
 * and returns its input
 */
@RequiredArgsConstructor
public class IsOneOf implements Rule<String,String> {

    public static @NonNull IsOneOf these(@NonNull String... expectedValues) {
        return new IsOneOf(ImmutableSet.copyOf(expectedValues));
    }

    private final @NonNull ImmutableSet<String> expectedValues;

    @Override
    public @NonNull Validation<String> validate(@NonNull String input) {
        if (expectedValues.contains(input)) {
            return Validation.valid(input);
        }
        return Validation.invalid();
    }
}
