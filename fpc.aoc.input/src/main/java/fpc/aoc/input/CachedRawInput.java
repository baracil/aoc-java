package fpc.aoc.input;

import fpc.aoc.api.RawInput;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RequiredArgsConstructor
public class CachedRawInput implements RawInput {

  private final AtomicReference<List<String>> lines = new AtomicReference<>();
  private final RawInput delegate;

  @Override
  public List<String> read() {
    return lines.updateAndGet(list -> list != null ? list : delegate.read());
  }
}
