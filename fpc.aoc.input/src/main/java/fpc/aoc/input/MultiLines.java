package fpc.aoc.input;

import fpc.aoc.api.RawInput;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class MultiLines implements RawInput {

  @NonNull
  private final String multiLines;

  @Override
  public @NonNull List<String> read() {
    return Arrays.asList(multiLines.split("\\R"));
  }
}
