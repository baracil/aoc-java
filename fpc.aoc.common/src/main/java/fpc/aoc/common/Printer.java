package fpc.aoc.common;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class Printer {

    public Printer(@NonNull Function<? super Position, ? extends String> toPixel) {
        this(toPixel," ");
    }

    @NonNull
    private final Function<? super Position,? extends String> toPixel;

    private final String emptyPixel;

    @NonNull
    public String printOnOneLine(@NonNull Supplier<Stream<Position>> knownPositions) {
        return String.join("\n", print(knownPositions));
    }

    @NonNull
    public List<String> print(@NonNull Supplier<Stream<Position>> knownPositions) {
        final IntSummaryStatistics statisticsOnX = knownPositions.get().mapToInt(Position::x).summaryStatistics();
        final IntSummaryStatistics statisticsOnY = knownPositions.get().mapToInt(Position::y).summaryStatistics();

        final int width = statisticsOnX.getMax() - statisticsOnX.getMin() + 1;
        final int height = statisticsOnY.getMax() - statisticsOnY.getMin() + 1;

        final String[] image = new String[width*height];

        knownPositions.get()
                      .forEach(p -> {
                          final int x = p.x() - statisticsOnX.getMin();
                          final int y = p.y() - statisticsOnY.getMin();
                          final int idx = x+width*y;
                          image[idx] = toPixel.apply(p);
                      });

        return IntStream.range(0,height)
                        .map(h -> h*width)
                        .mapToObj(i -> Arrays.stream(image, i, i + width).map( s->s==null?emptyPixel:s).collect(Collectors.joining()))
                        .toList();
    }
}
