package fpc.aoc.common;

import lombok.NonNull;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author perococco
 **/
public interface SynchronizedValue<T> {

    T value();

    @NonNull
    default T waitForValue(@NonNull T expectedValue) throws InterruptedException {
        return waitForValueMatching(expectedValue::equals);
    }

    @NonNull
    default T waitForValueMatching(@NonNull Predicate<T> valueTester) throws InterruptedException {
        return transformAndWaitForValue(t -> valueTester.test(t) ? Optional.of(t) : Optional.empty());
    }

    @NonNull <U> U transformAndWaitForValue(@NonNull Function<T,Optional<U>> valueTester) throws InterruptedException;
}
