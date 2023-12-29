package fpc.aoc.year2020.day7.structures;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class OneLineParsing {

  @Getter
  private final @NonNull String colorName;

  @Getter
  private final @NonNull Map<String, Integer> content;
}
