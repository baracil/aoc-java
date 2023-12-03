package fpc.aoc.input;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.ArrayOfChar;
import lombok.NonNull;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@FunctionalInterface
public interface Converter<I> extends Function<Stream<String>,I> {

    /**
     * Perform the conversion
     * @param input the input stream
     * @return the converted value
     */
    @NonNull I convert(@NonNull Stream<String> input);

    /**
     * @see #convert(Stream)
     */
    @Override
    default @NonNull I apply(Stream<String> stringStream) {
        return convert(stringStream);
    }

    /**
     * @param after the function to apply to the converted result
     * @param <V> the type of the value return by the provided function
     * @return a converter that apply this converter and then the provided function
     */
    @Override
    default <V> Converter<V> andThen(Function<? super I, ? extends V> after) {
        return s -> after.apply(this.convert(s));
    }

    /**
     * Converter the stream of lines to a stream of integer (each line is parse to an integer)
     */
    Converter<IntStream> TO_INT_STREAM = s -> s.mapToInt(Integer::parseInt);
    /**
     * returne the first element of the stream
     */
    Converter<String> FIRST_LINE = s -> s.findFirst().orElseThrow(() -> new AOCException("Empty input"));
    /**
     * do not perform any conversion, just return the stream of lines
     */
    Converter<Stream<String>> IDENTITY = s -> s;
    /**
     * collect all lines into a list
     */
    Converter<List<String>> ALL_LINES = Stream::toList;

    Converter<long[]> TO_ARRAY_OF_LONG = s -> s.mapToLong(Long::parseLong).toArray();

    Converter<int[]> TO_ARRAY_OF_INT = s -> s.mapToInt(Integer::parseInt).toArray();
    /**
     * transform the input stream into an array of char (using '.' to fill the spaces)
     */
    Converter<ArrayOfChar> TO_ARRAY_OF_CHAR = s -> s.collect(ArrayOfChar.collector('.'));
}
