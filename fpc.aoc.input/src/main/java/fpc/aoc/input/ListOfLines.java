package fpc.aoc.input;

import fpc.aoc.api.RawInput;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListOfLines implements RawInput {

  @NonNull
  private final List<String> lines;

  @Override
  public List<String> read() {
    return lines;
  }
}
