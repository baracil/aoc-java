package fpc.aoc.year2020.day20.structures;

import fpc.aoc.common.Table;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class Dictionary {

  @NonNull
  private final Table<String, String, Set<ImageTile>> table;

  public Stream<ImageTile> findWithUpMatching(String reverseDown) {
    return Optional.ofNullable(table.column(reverseDown))
        .stream()
        .map(Map::values)
        .flatMap(Collection::stream)
        .flatMap(Collection::stream);
  }

  public Stream<ImageTile> findWithLeftMatching(String reversedRight) {
    return Optional.ofNullable(table.row(reversedRight))
        .stream()
        .map(Map::values)
        .flatMap(Collection::stream)
        .flatMap(Collection::stream);
  }

  public Stream<ImageTile> findWithLeftAndUpMatching(String right, String down) {
    return Optional.ofNullable(table.get(right, down))
        .stream()
        .flatMap(Collection::stream);

  }

  public Stream<ImageTile> allTiles() {
    return table.values().stream().flatMap(Collection::stream);
  }

  public Stream<ImageTile> allCorners() {
    return table.values()
        .stream()
        .filter(s -> s.size() == 1)
        .flatMap(Collection::stream);
  }
}
