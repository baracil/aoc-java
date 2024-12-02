package fpc.aoc.year2020.day20.structures;

import fpc.aoc.common.Table;
import fpc.aoc.common.Transformation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DictionaryBuilder {

  public static Dictionary build(List<ImageTile> imageTiles) {
    return new DictionaryBuilder(imageTiles).build();
  }

  private final List<ImageTile> imageTiles;

  private final Table<String, String, Set<ImageTile>> table = Table.create();

  private Dictionary build() {
    for (ImageTile imageTile : imageTiles) {
      addOneImageTile(imageTile);
    }
    return new Dictionary(table);
  }

  private void addOneImageTile(final ImageTile imageTile) {
    Transformation.all()
        .map(imageTile::transform)
        .forEach(this::addToTable);
  }

  private void addToTable(ImageTile imageTile) {
    final var left = imageTile.leftBorder();
    final var up = imageTile.upperBorder();
    Set<ImageTile> set = table.get(left, up);
    if (set == null) {
      set = new HashSet<>();
      table.put(left, up, set);
    }
    set.add(imageTile);
  }

}
