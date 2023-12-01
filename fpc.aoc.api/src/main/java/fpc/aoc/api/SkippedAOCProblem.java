package fpc.aoc.api;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SkippedAOCProblem<S> implements AOCProblem<S> {

    private final @NonNull AOCProblem<S> delegate;

    @Override
    public @NonNull AOCProblemId id() {
        return delegate.id();
    }

    @Override
    public @NonNull S solve() {
        return delegate.solve();
    }

    @Override
    public boolean isSkipped() {
        return true;
    }

    @Override
    public @NonNull AOCProblem<S> skipped() {
        return this;
    }
}
