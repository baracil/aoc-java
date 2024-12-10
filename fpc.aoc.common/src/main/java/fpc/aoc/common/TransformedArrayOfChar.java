package fpc.aoc.common;

import lombok.Getter;
import lombok.NonNull;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TransformedArrayOfChar extends AbstractArrayOfChar implements ArrayOfChar {

  @Getter
  private final Transformation transformation;

  private final BaseArrayOfChar delegate;

  @Getter
  private final int width;

  @Getter
  private final int height;

  private final IntBinaryOperator xTransformer;
  private final IntBinaryOperator yTransformer;

  public TransformedArrayOfChar(Transformation transformation, BaseArrayOfChar delegate) {
    this.transformation = transformation;
    this.delegate = delegate;
    this.width = switch (transformation.rotation()) {
      case _000, _180 -> delegate.width();
      case _270, _090 -> delegate.height();
    };
    this.height = switch (transformation.rotation()) {
      case _000, _180 -> delegate.height();
      case _270, _090 -> delegate.width();
    };
    this.xTransformer = transformation.xTransformer();
    this.yTransformer = transformation.yTransformer();
  }

  @Override
  public void print(PrintStream printStream) {
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        printStream.print(get(x, y));
      }
      printStream.println();
    }

  }

  @Override
  public char filling() {
    return delegate.filling();
  }

  @Override
  public char get(Position position) {
    return get(position.x(), position.y());
  }

  @Override
  public char get(int x, int y) {
    if (x < 0 || x >= width || y < 0 || y >= height) {
      return delegate.filling();
    }
    final int ox = Tools.mod(xTransformer.applyAsInt(x, y), delegate.width());
    final int oy = Tools.mod(yTransformer.applyAsInt(x, y), delegate.height());


    return delegate.get(ox, oy);
  }

  @Override
  public ArrayOfChar rotate(Rotation rotation) {
    return transform(t -> t.compose(rotation));
  }

  @Override
  public ArrayOfChar flip(Flipping flipping) {
    return transform(t -> t.compose(flipping));
  }

  @Override
  public ArrayOfChar transform(Transformation transformation) {
    return transform(t -> t.compose(transformation));
  }

  private ArrayOfChar transform(UnaryOperator<Transformation> modifier) {
    final Transformation newTransformation = modifier.apply(this.transformation);
    if (newTransformation.equals(transformation)) {
      return this;
    }
    return new TransformedArrayOfChar(newTransformation, delegate);
  }

  @NonNull
  public <T> T[] convert(Function<? super Character, ? extends T> converter, IntFunction<T[]> arrayCreator) {
    final var result = arrayCreator.apply(this.width * this.height);
    int i = 0;
    for (int y = 0; y < this.height; y++) {
      for (int x = 0; x < this.width; x++) {
        result[i++] = converter.apply(get(x, y));
      }
    }
    return result;
  }

  @Override
  public <T> Stream<T> where(char value, BiFunction<Integer, Integer, T> pointFactory) {
    return IntStream.range(0, width * height)
        .mapToObj(idx -> {
          final int x = idx % width;
          final int y = idx / width;
          if (get(x, y) == value) {
            return pointFactory.apply(x, y);
          }
          return null;
        }).filter(Objects::nonNull);
  }

  @Override
  public Optional<Position> findMatching(char s) {
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        if (get(x, y) == s) {
          return Optional.of(Position.of(x, y));
        }
      }
    }
    return Optional.empty();
  }

  @Override
  public List<Position> findAllMatching(char s) {
    final var result = new ArrayList<Position>();
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        if (get(x, y) == s) {
          result.add(Position.of(x, y));
        }
      }
    }
    return result;
  }
}
