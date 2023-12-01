package fpc.aoc.input;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class MultiLines implements Input<Stream<String>> {

    @NonNull
    private final String multiLines;

    @Override
    public @NonNull Stream<String> readData() {
        return Arrays.stream(multiLines.split("\\R"));
    }
}
