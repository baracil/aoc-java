package fpc.aoc.input;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class ListOfLines implements Input<Stream<String>> {

    @NonNull
    private final List<String> lines;

    @Override
    public @NonNull Stream<String> readData() {
        return lines.stream();
    }
}
