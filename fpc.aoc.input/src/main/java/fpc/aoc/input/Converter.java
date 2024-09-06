package fpc.aoc.input;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Tools;
import lombok.NonNull;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@FunctionalInterface
public interface Converter<I> extends Function<List<String>, I> {

  /**
   * Perform the conversion
   *
   * @param input the input stream
   * @return the converted value
   */
  @NonNull I convert(@NonNull List<String> input);

  /**
   * @see #convert(List)
   */
  @Override
  default @NonNull I apply(List<String> stringStream) {
    return convert(stringStream);
  }

  /**
   * @param after the function to apply to the converted result
   * @param <V>   the type of the value return by the provided function
   * @return a converter that apply this converter and then the provided function
   */
  @Override
  default <V> Converter<V> andThen(Function<? super I, ? extends V> after) {
    return s -> after.apply(this.convert(s));
  }

  /**
   * Converter the stream of lines to a stream of integer (each line is parse to an integer)
   */
  Converter<IntStream> TO_INT_STREAM = s -> s.stream().mapToInt(Integer::parseInt);
  /**
   * returne the first element of the stream
   */
  Converter<String> FIRST_LINE = s -> s.stream().findFirst().orElseThrow(() -> new AOCException("Empty input"));
  /**
   * do not perform any conversion, just return the stream of lines
   */
  Converter<Stream<String>> TO_STREAM = Collection::stream;
  /**
   * collect all lines into a list
   */
  Converter<List<String>> IDENTITY = l -> l;

  Converter<long[]> TO_ARRAY_OF_LONG = l -> l.stream().mapToLong(Long::parseLong).toArray();

  Converter<int[]> TO_ARRAY_OF_INT = s -> s.stream().mapToInt(Integer::parseInt).toArray();
  /**
   * transform the input stream into an array of char (using '.' to fill the spaces)
   */
  Converter<ArrayOfChar> TO_ARRAY_OF_CHAR = l -> ArrayOfChar.from(l, '.');

  static <U> Converter<List<U>> forItem(Function<? super String, ? extends U> itemMapper) {
    return list -> Tools.map(list, itemMapper);
  }

  static <U> Converter<Stream<U>> forStreamOfItems(Function<? super String, ? extends U> itemMapper) {
    return list -> list.stream().map(itemMapper);
  }

  static <U> Converter<U> from(Converter<U> converter) {
    return converter;
  }

  static Converter<ArrayOfChar> toArrayOfChar(char filling) {
    return s -> ArrayOfChar.from(s, filling);
  }

}
