package fpc.aoc.common;

import lombok.NonNull;

import java.io.PrintStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface Array {

  static @NonNull ArrayOfChar create(@NonNull char[] data, char filling, int width, int height) {
    return new BaseArrayOfChar(data, filling, width, height);
  }

  static <T> @NonNull GenericArray<T> create(@NonNull T[] data, int width, int height) {
    return new BaseGenericArray<>(data, width, height);
  }

  void print(@NonNull PrintStream printStream);

  default void printToStandardOutput() {
    print(System.out);
  }

  int width();

  int height();

  @NonNull
  default Stream<Position> positionStream() {
    final int width = width();
    return IntStream.range(0, width * height()).mapToObj(i -> Position.of(i % width, i / width));
  }

  default boolean isInside(Position position) {
    final var x = position.x();
    final var y = position.y();
    return (x >= 0 && x < width() && y >= 0 && y < height());
  }

}
