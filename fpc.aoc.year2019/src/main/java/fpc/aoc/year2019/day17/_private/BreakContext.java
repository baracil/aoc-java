package fpc.aoc.year2019.day17._private;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BreakContext {

    @NonNull
    private final String[] tokens;

    @NonNull
    private final MovementFunction[] functions;

    public BreakContext(String[] tokens) {
        this.tokens = tokens;
        this.functions = new MovementFunction[tokens.length];
    }

    public BreakContext set(int start, int end, MovementFunction function) {
        final MovementFunction[] copy = functions.clone();
        for (int i = start; i < end; i++) {
            copy[i] = function;
        }
        return new BreakContext(tokens,copy);
    }

}
