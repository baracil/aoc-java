package fpc.aoc.common;

import lombok.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * @author Bastien Aracil
 **/
public interface ArrayOfChar extends Array, ArrayOfCharReader {


  static ArrayOfChar from(String data, char filling) {
    return Arrays.stream(data.split("\n"))
        .collect(ArrayOfChar.collector(filling));
  }

  static ArrayOfChar from(List<String> data, char filling) {
    return data.stream().collect(ArrayOfChar.collector(filling));
  }

  static ArrayOfChar of(char[] data, char filling, int width, int height) {
    return new BaseArrayOfChar(data, filling, width, height);
  }

  static ArrayOfChar from(Set<Position> positions, char withPosition, char withoutPosition, int margin) {
    final var minMax = positions.stream().collect(PositionMinMax.COLLECTOR);
    final var width = (minMax.maxX() - minMax.minX() + 1) + margin * 2;
    final var height = (minMax.maxY() - minMax.minY() + 1) + margin * 2;
    final var data = new char[width * height];
    Arrays.fill(data, withoutPosition);
    final var helper = GridHelper.create(width, height);
    for (Position position : positions) {
      final var x = position.x() - minMax.minX() + margin;
      final var y = position.y() - minMax.minY() + margin;
      data[helper.linearIndexFor(x, y)] = withPosition;
    }
    return of(data, withoutPosition, width, height);
  }

  Transformation transformation();

  /**
   * @param position the seek position
   * @return the char at the provided position
   */
  char get(Position position);

  /**
   * @return the char at x and y
   */
  char get(int x, int y);

  char filling();

  /**
   * Collect a stream of string to an array of char
   *
   * @param filling the char to use as a filling for positions outside the array
   * @return an {@link ArrayOfChar} built from the stream of string
   */
  @NonNull
  static Collector<String, ?, ArrayOfChar> collector(char filling) {
    return BaseArray.baseCollector(
        String::toCharArray,
        c -> c.length,
        char[]::new,
        a -> Arrays.fill(a, filling),
        (source, destination, destinationOffset) -> System.arraycopy(source, 0, destination, destinationOffset,
            source.length),
        (source, width, height) -> new BaseArrayOfChar(source, filling, width, height)


    );
  }

  @NonNull
  <T> T[] convert(Function<? super Character, ? extends T> converter, IntFunction<T[]> arrayCreator);

  String asString();

  ArrayOfChar rotate(Rotation rotation);

  ArrayOfChar flip(Flipping flipping);

  default String upperBorder() {
    return extract(i -> i, i -> 0, width());
  }

  default String lowerBorder() {
    final int width = width();
    final int height = height();
    return extract(i -> width - 1 - i, i -> height - 1, width);
  }

  default String leftBorder() {
    final int width = width();
    final int height = height();
    return extract(i -> 0, i -> height - 1 - i, height);
  }

  default String rightBorder() {
    final int width = width();
    final int height = height();
    return extract(i -> width - 1, i -> i, height);
  }

  default String extract(IntUnaryOperator xGetter, IntUnaryOperator yGetter, int length) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      final int x = xGetter.applyAsInt(i);
      final int y = yGetter.applyAsInt(i);
      sb.append(get(x, y));
    }
    return sb.toString();
  }

  <T> Stream<T> where(char value, BiFunction<Integer,Integer,T> pointFactory);

  ArrayOfChar transform(Transformation transformation);

  Optional<Position> findMatching(char s);

  List<Position> findAllMatching(char s);

}
