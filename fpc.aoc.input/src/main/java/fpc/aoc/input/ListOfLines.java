package fpc.aoc.input;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public class ListOfLines implements Input<Stream<String>> {

    @NonNull
    private final ImmutableList<String> lines;

    @Override
    public @NonNull Stream<String> readData() {
        return lines.stream();
    }
}
