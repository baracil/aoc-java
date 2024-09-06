package fpc.aoc.computer.io._private;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChainedOutput implements Output {

    @NonNull
    private final Output first;

    @NonNull
    private final Output second;

    @Override
    public void write(@NonNull String value) {
        first.write(value);
        second.write(value);
    }

}
