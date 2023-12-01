package fpc.aoc.common.rules;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Validation<T> {

    private static final Validation<?> INVALID = new Validation<>(null);

    public static <O> Validation<O> valid(@NonNull O value) {
        return new Validation<>(value);
    }
    public static <O> Validation<O> invalid() {
        return (Validation<O>) INVALID;
    }

    private final T value;

    public boolean isValid() {
        return value != null;
    }

    public <S> Validation<S> map(@NonNull Rule<? super T,S> rule) {
        if (value == null) {
            return invalid();
        }
        return rule.validate(value);
    }
}
