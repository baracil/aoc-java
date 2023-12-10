package fpc.aoc.common;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Bastien Aracil
 **/
@Getter
@RequiredArgsConstructor
public abstract class BaseArray implements Array {

    private final int width;

    private final int height;

    protected boolean isPositionInRange(@NonNull Position position) {
        return isInRange(position.x(),  position.y());
    }

    protected boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < width && y < height;
    }

    protected int xyToIndex(int x, int y) {
        return x + y*width;
    }

    protected int positionToIndex(@NonNull Position position) {
        return xyToIndex(position.x(),position.y());
    }

    @Override
    public void print(@NonNull PrintStream printStream) {
        int idx = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                printSingleElement(printStream,idx++);
            }
            printStream.println();
        }
    }

    protected abstract void printSingleElement(@NonNull PrintStream printStream, int elementIndex);

    @NonNull
    public Stream<Position> positionStream() {
        return IntStream.range(0,width*height).mapToObj(i -> Position.of(i%width,i/width));
    }

    @NonNull
    public static <A,B> Collector<String,?,B> baseCollector(
            @NonNull Function<? super String, ? extends A> lineTransformer,
            @NonNull ToIntFunction<? super A> lineSizeEvaluator,
            @NonNull IntFunction<? extends A> arrayCreator,
            @NonNull Consumer<? super A> arrayInitializer,
            @NonNull ArrayCopier<? super A> arrayCopier,
            @NonNull ArrayBuilder<? super A, ? extends B> arrayBuilder
    ) {
        return Collector.of(() -> new Accumulator<>(lineTransformer,lineSizeEvaluator,arrayCreator,arrayInitializer,arrayCopier,arrayBuilder),
                            Accumulator::addLine,
                            (a1,a2)-> {throw new AOCException("Cannot combine when building ArrayOfChar");},
                            Accumulator::buildArray
                            );
    }

    public interface ArrayCopier<A> {
        void copy(@NonNull A source,@NonNull A destination, int destinationOffset);
    }

    public interface ArrayBuilder<A,B> {
        B build(@NonNull A source, int width, int height);
    }

    @RequiredArgsConstructor
    private static class Accumulator<A,B> {

        private final Function<? super String, ? extends A> lineTransformer;
        private final ToIntFunction<? super A> lineSizeEvaluator;
        private final IntFunction<? extends A> arrayCreator;
        private final Consumer<? super A> arrayInitializer;
        private final ArrayCopier<? super A> arrayCopier;
        private final ArrayBuilder<? super A, ? extends B> arrayBuilder;

        private final List<A> lines = new ArrayList<>();

        public void addLine(@NonNull String line) {
            final A newLine = lineTransformer.apply(line);
            lines.add(newLine);
        }

        @NonNull
        public B buildArray() {
            final int height = lines.size();
            final int width = lines.stream().mapToInt(lineSizeEvaluator).max().orElse(0);

            final A array = arrayCreator.apply(width*height);
            arrayInitializer.accept(array);
            for (int h = 0; h < height; h++) {
                final A line = lines.get(h);
                arrayCopier.copy(line,array,h*width);
            }

            return arrayBuilder.build(array, width, height);
        }
    }
}
