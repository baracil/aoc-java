package fpc.aoc.common;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class Lazy<T> {

    private final AtomicReference<T> value = new AtomicReference<>();

    @NonNull
    private final Supplier<T> supplier;

    @NonNull
    public T get() {
        return value.updateAndGet(v -> v == null?supplier.get():v);
    }
}
