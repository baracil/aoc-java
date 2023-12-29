package fpc.aoc.year2023.day10;

import fpc.aoc.common.*;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collector;

public class Map {

  private final GridHelper helper;
  private final int startIdx;
  private final GenericArray<Tile> tiles;

  public Map(@NonNull GenericArray<Tile> tiles, int startIdx) {
    this.helper = GridHelper.create(tiles.width(), tiles.height());
    this.startIdx = startIdx;
    this.tiles = tiles;
  }

  public void print() {
    tiles.printToStandardOutput(Tile::displayed);
  }


  public GenericArray<Tile> cleaned() {
    final var cycle = cycle();
    final var points = new HashSet<>(cycle);
    return tiles.map((p, t) -> points.contains(p) ? t : Tile.FLOOR, Tile[]::new);
  }

  public List<Position> cycle() {
    final var start = helper.positionFor(startIdx);
    final List<Position> result = new ArrayList<>();
    final var startTile = tiles.get(start);

    var pos = start;
    var out = startTile.getAny();
    if (out == null) {
      throw new IllegalArgumentException("Invalid start " + startTile);
    }

    do {
      result.add(pos);
      pos = pos.displaced(out);
      final var tile = tiles.get(pos);
      out = tile.getOther(out.opposite());
      if (out == null) {
        throw new IllegalArgumentException("Invalid tile " + tile);
      }
    } while (!pos.equals(start));

    return result;
  }

  public record ZoneType(boolean inside, int counter) {

    public ZoneType toggle() {
      return new ZoneType(!inside, counter);
    }

    public ZoneType in() {
      return new ZoneType(!inside, counter + 1);
    }

    public ZoneType out() {
      final var c = counter - 1;
      return new ZoneType((c == 0) != inside, c);
    }

    public ZoneType next(Tile tile) {
      final var inside = this.inside;
      final var counter = this.counter;
      return switch (tile) {
        case PIPE_H -> this;
        case PIPE_V -> this.toggle();
        case CORNER_L -> this.toggle();
        case CORNER_J -> this;
        case CORNER_7 -> this;
        case CORNER_F -> this.toggle();
        case FLOOR -> this;
        case START -> this;
      };
    }
  }


  private static Map create(Tile[] tiles, int width, int height) {
    int idx = -1;
    for (int i = 0; i < tiles.length; i++) {
      if (tiles[i] == Tile.START) {
        idx = i;
        break;
      }
    }


    final IntFunction<Tile> getter = i -> i < 0 || i >= tiles.length ? Tile.FLOOR : tiles[i];


    tiles[idx] = Tile.estimateStart(
        getter.apply(idx - width),
        getter.apply(idx + 1),
        getter.apply(idx + width),
        getter.apply(idx - 1)
    );

    return new Map(new BaseGenericArray<>(tiles, width, height), idx);
  }

  public static final Collector<String, ?, Map> COLLECTOR = BaseArray.baseCollector(
      s -> s.chars().mapToObj(Tile::parse).toArray(Tile[]::new),
      s -> s.length,
      Tile[]::new,
      t -> Arrays.fill(t, Tile.FLOOR),
      Map::arrayCopy,
      Map::create
  );

  private static void arrayCopy(Tile[] source, Tile[] destination, int destinationOffset) {
    System.arraycopy(source, 0, destination, destinationOffset, source.length);
  }

}
