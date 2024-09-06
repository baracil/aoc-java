package fpc.aoc.year2019.day13._private;

import fpc.aoc.common.Position;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Tile {

  @NonNull
  private final Position position;

  @NonNull
  private final TileType type;

}
