package fpc.aoc.common;

import lombok.NonNull;

import java.io.PrintStream;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.IntFunction;

public class BaseGenericArray<T> extends BaseArray implements GenericArray<T> {

  protected final @NonNull T[] data;

  public BaseGenericArray(@NonNull T[] data, int width, int height) {
    super(width, height);
    this.data = data;
  }

  @Override
  public void forEach(BiConsumer<Position, T> consumer) {
    final var helper = GridHelper.create(width(), height());
    for (int i = 0; i < data.length; i++) {
      consumer.accept(helper.positionFor(i), data[i]);
    }
  }

  @Override
  public <U> GenericArray<U> map(BiFunction<? super Position, ? super T, ? extends U> mapper, IntFunction<U[]> arrayCreator) {
    final var helper = GridHelper.create(width(), height());
    final var result = arrayCreator.apply(data.length);
    for (int i = 0; i < data.length; i++) {
      final var pos = helper.positionFor(i);
      result[i] = mapper.apply(pos, data[i]);
    }
    return new BaseGenericArray<>(result, width(), height());
  }

  @Override
  public @NonNull T get(@NonNull Position position) {
    return get(position.x(), position.y());
  }

  @Override
  public @NonNull T get(int x, int y) {
    if (isInRange(x, y)) {
      return data[xyToIndex(x, y)];
    }
    throw new IndexOutOfBoundsException("x=" + x + " y=" + y + "  width=" + width() + " height=" + height());
  }

  @Override
  public void print(@NonNull PrintStream printStream, BiFunction<? super Position, ? super T, ? extends String> toString) {
    int idx = 0;
    for (int y = 0; y < height(); y++) {
      for (int x = 0; x < width(); x++) {
        final var s = toString.apply(Position.of(x, y), data[idx++]);
        printStream.print(s);
      }
      printStream.println();
    }

  }

  @Override
  protected void printSingleElement(@NonNull PrintStream printStream, int elementIndex) {
    printElement(printStream, data[elementIndex]);
  }

  protected void printElement(@NonNull PrintStream printStream, T element) {
    printStream.print(element);
  }


}
