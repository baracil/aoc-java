package fpc.aoc.common;

import java.io.PrintStream;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;

public interface GenericArray<T> extends Array {

  T get(Position position);

  T get(int x, int y);


  <U> GenericArray<U> map(BiFunction<? super Position, ? super T, ? extends U> mapper, IntFunction<U[]> arrayCreator);

  void print(PrintStream printStream, BiFunction<? super Position, ? super T, ? extends String> toString);

  default void print(PrintStream printStream, Function<? super T, ? extends String> toString) {
    print(printStream, (p, t) -> toString.apply(t));
  }

  default void printToStandardOutput(BiFunction<? super Position, ? super T, ? extends String> toString) {
    print(System.out, toString);
  }

  default void printToStandardOutput(Function<? super T, ? extends String> toString) {
    print(System.out, toString);
  }

  @Override
  default void print(PrintStream printStream) {
    print(printStream, String::valueOf);
  }

  @Override
  default void printToStandardOutput() {
    printToStandardOutput(String::valueOf);
  }

  void forEach(BiConsumer<Position, T> consumer);
}
