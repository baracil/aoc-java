package fpc.aoc.year2020.day4.structures;

import java.util.Spliterator;
import java.util.function.Consumer;

public class PassportSplitter implements Spliterator<Passport> {


  @Override
  public boolean tryAdvance(Consumer<? super Passport> action) {
    return false;
  }

  @Override
  public Spliterator<Passport> trySplit() {
    return null;
  }

  @Override
  public long estimateSize() {
    return 0;
  }

  @Override
  public int characteristics() {
    return 0;
  }
}
