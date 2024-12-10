package fpc.aoc.common;

import lombok.NonNull;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Bastien Aracil
 **/
public class BaseArrayOfChar extends BaseArray implements ArrayOfChar {

  private final char[] data;

  private final char filling;

  private final LazyString asString = LazyString.of(this::computeAsString);

  public BaseArrayOfChar(char[] data, char filling, int width, int height) {
    super(width, height);
    this.data = data;
    this.filling = filling;
  }

  @Override
  public Transformation transformation() {
    return Transformation.IDENTITY;
  }

  @Override
  public char filling() {
    return filling;
  }

  /**
   * @param position the seek position
   * @return the char at the provided position
   */
  public char get(Position position) {
    if (isPositionInRange(position)) {
      return data[positionToIndex(position)];
    }
    return filling;
  }

  /**
   * @return the char at x and y
   */
  public char get(int x, int y) {
    if (isInRange(x, y)) {
      return data[xyToIndex(x, y)];
    }
    return filling;
  }

  @NonNull
  public <T> T[] convert(Function<? super Character, ? extends T> converter, IntFunction<T[]> arrayCreator) {
    return IntStream.range(0, width() * height()).mapToObj(i -> converter.apply(data[i])).toArray(arrayCreator);
  }

  @Override
  protected void printSingleElement(PrintStream printStream, int elementIndex) {
    printStream.print(data[elementIndex]);
  }

  public String asString() {
    return asString.toString();
  }


  @Override
  public ArrayOfChar rotate(Rotation rotation) {
    return new TransformedArrayOfChar(Transformation.of(rotation, Flipping.NONE), this);
  }

  @Override
  public ArrayOfChar flip(Flipping flipping) {
    return new TransformedArrayOfChar(Transformation.of(Rotation._000, flipping), this);
  }

  @Override
  public ArrayOfChar transform(Transformation transformation) {
    return new TransformedArrayOfChar(transformation, this);
  }

  @Deprecated
  public void set(int x, int y, char value) {
    this.data[xyToIndex(x, y)] = value;
  }

  public String computeAsString() {
    final int width = width();
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < data.length; i++) {
      if (i != 0 && (i % width) == 0) {
        sb.append('\n');
      }
      sb.append(data[i]);
    }
    return sb.toString();
  }

  @Override
  public String toString() {
    return asString();
  }

  @Override
  public Optional<Position> findMatching(char s) {
    for (int i = 0; i < data.length; i++) {
      if (data[i] == s) {
        return Optional.of(Position.of(i % width(), i / width()));
      }
    }
    return Optional.empty();
  }

  @Override
  public List<Position> findAllMatching(char s) {
    final var result = new ArrayList<Position>();
    for (int i = 0; i < data.length; i++) {
      if (data[i] == s) {
        result.add(Position.of(i % width(), i / width()));
      }
    }
    return result;
  }

  @Override
  public <T> Stream<T> where(char value, BiFunction<Integer, Integer, T> pointFactory) {
    return IntStream.range(0, data.length)
        .filter(idx -> data[idx] == value)
        .mapToObj(idx -> indexToPosition(idx, pointFactory));
  }

  protected <T> T indexToPosition(int index, BiFunction<Integer, Integer, T> factory) {
    final var x = index % width();
    final var y = index / width();
    return factory.apply(x, y);
  }

}
