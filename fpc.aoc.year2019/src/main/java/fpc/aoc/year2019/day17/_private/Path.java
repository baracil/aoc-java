package fpc.aoc.year2019.day17._private;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class Path {

    private final int initialDisplacement;

    @NonNull
    private final List<PathElement> elements;

    @NonNull
    public String[] toTokens() {
        return Stream.concat(
                initialDisplacement<=0?Stream.empty():Stream.of(String.valueOf(initialDisplacement)),
                elements.stream().flatMap(PathElement::stream)
        ).toArray(String[]::new);
    }


    @Override
    public String toString() {
        return String.join(",", toTokens());
    }
}
