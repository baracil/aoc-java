package fpc.aoc.api;

import lombok.NonNull;

public interface AOCProblem<S> extends Comparable<AOCProblem<?>> {

    @NonNull
    AOCProblemId id();

    @NonNull
    S solve();

    default boolean isSkipped() {
        return false;
    }

    @NonNull
    default String problemName() {
        return id().day()+" "+id().part();
    }

    @Override
    default int compareTo(@NonNull AOCProblem<?> other) {
        return this.id().compareTo(other.id());
    }

    default @NonNull AOCProblem<S> skipped() {
        return new SkippedAOCProblem<>(this);
    }
}
