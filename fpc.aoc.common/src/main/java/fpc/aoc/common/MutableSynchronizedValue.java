package fpc.aoc.common;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

/**
 * @author Bastien Aracil
 **/
public class MutableSynchronizedValue<T> implements SynchronizedValue<T> {

    @NonNull
    private Holder<T> holder;

    private final Lock lock = new ReentrantLock();
    private final Condition holderChanged = lock.newCondition();

    public MutableSynchronizedValue(@NonNull T value) {
        this.holder = Holder.withValue(value);
    }

    @Override
    public T value() {
        return holder.get();
    }

    public void onError(@NonNull String errorMessage) {
        setHolder(Holder.error(errorMessage));
    }

    public void setValue(@NonNull T value) {
        setHolder(Holder.withValue(value));
    }

    private void setHolder(@NonNull Holder<T> holder) {
        lock.lock();
        try {
            this.holder = holder;
            holderChanged.signalAll();
        } finally {
            lock.unlock();
        }
    }

    @NonNull
    @Override
    public <U> U transformAndWaitForValue(@NonNull Function<T,Optional<U>> valueTester) throws InterruptedException {
        lock.lock();
        try {
            while (true) {
                final Optional<U> transformed = valueTester.apply(holder.get());
                if (transformed.isPresent()) {
                    return transformed.get();
                }
                holderChanged.await();
            }
        } finally {
            lock.unlock();
        }
    }

    @RequiredArgsConstructor
    private static class Holder<T> {

        public static <T> Holder<T> withValue(@NonNull T value) {
            return new Holder<T>(value,null);
        }

        public static <T> Holder<T> error(@NonNull String errorMessage) {
            return new Holder<>(null,errorMessage);
        }

        private final T value;

        private final String error;

        public T get() {
            if (error != null) {
                throw new AOCException("Error while getting value : "+error);
            } else {
                return value;
            }
        }
    }
}
