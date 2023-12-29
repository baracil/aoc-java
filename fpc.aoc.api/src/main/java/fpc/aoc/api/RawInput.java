package fpc.aoc.api;

import lombok.NonNull;

import java.util.List;

public interface RawInput extends Input<List<String>> {

  @NonNull List<String> read();
}
