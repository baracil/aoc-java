package fpc.aoc.year2022.day1;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class CarriedCalory implements Iterable<Long> {

  private final @NonNull List<String> input;

  @Override
  public Iterator<Long> iterator() {
    return new CarriedCaloryIterator();
  }

  public class CarriedCaloryIterator implements Iterator<Long> {

    private int idx = 0;

    private Long next;

    public CarriedCaloryIterator() {
      this.idx = 0;
      getNext();
    }

    private void getNext() {
      if (idx >= input.size()) {
        next = null;
        return;
      }
      long value = 0;
      while (idx < input.size()) {
        final var line = input.get(idx++);
        if (line.isBlank()) {
          break;
        }
        value += Integer.parseInt(line);
      }
      next = value;
    }

    @Override
    public boolean hasNext() {
      return next != null;
    }

    @Override
    public Long next() {
      if (next == null) {
        throw new NoSuchElementException();
      }
      final var current = next;
      getNext();
      return current;
    }
  }
}
