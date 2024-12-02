package fpc.aoc.api;

import java.util.List;

public interface RawInput extends Input<List<String>> {

  List<String> read();
}
