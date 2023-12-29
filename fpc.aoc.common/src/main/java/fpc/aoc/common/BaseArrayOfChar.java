package fpc.aoc.common;

import lombok.NonNull;

import java.io.PrintStream;
import java.util.Optional;

/**
 * @author Bastien Aracil
 **/
public class BaseArrayOfChar extends BaseArray implements ArrayOfChar {

  @NonNull
  private final char[] data;

  private final char filling;

  private final @NonNull LazyString asString = LazyString.of(this::computeAsString);

  public BaseArrayOfChar(@NonNull char[] data, char filling, int width, int height) {
    super(width, height);
    this.data = data;
    this.filling = filling;
  }

  @Override
  public @NonNull Transformation transformation() {
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
  public char get(@NonNull Position position) {
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

  @Override
  protected void printSingleElement(@NonNull PrintStream printStream, int elementIndex) {
    printStream.print(data[elementIndex]);
  }

  public @NonNull String asString() {
    return asString.toString();
  }


  @Override
  public @NonNull ArrayOfChar rotate(@NonNull Rotation rotation) {
    return new TransformedArrayOfChar(Transformation.of(rotation, Flipping.NONE), this);
  }

  @Override
  public @NonNull ArrayOfChar flip(@NonNull Flipping flipping) {
    return new TransformedArrayOfChar(Transformation.of(Rotation._000, flipping), this);
  }

  @Override
  public @NonNull ArrayOfChar transform(@NonNull Transformation transformation) {
    return new TransformedArrayOfChar(transformation, this);
  }

  @Deprecated
  public void set(int x, int y, char value) {
    this.data[xyToIndex(x, y)] = value;
  }

  public @NonNull String computeAsString() {
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
  public @NonNull Optional<Position> findMatching(char s) {
    for (int i = 0; i < data.length; i++) {
      if (data[i] == s) {
        return Optional.of(Position.of(i % width(), i / width()));
      }
    }
    return Optional.empty();
  }

}
