package fpc.aoc.day10;

import fpc.aoc.common.*;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

@RequiredArgsConstructor
public class Doubled {
  enum Type {
    I, O, L
  }

  private final GenericArray<Tile> tiles;
  private final Type[] types;
  private final GridHelper helper;

  public static final List<Orientation> ORIENTATIONS = List.of(Orientation.N,Orientation.W,Orientation.S,Orientation.E);

  public Doubled(GenericArray<Tile> tiles, Type[] types) {
    this.tiles = tiles;
    this.types = types;
    this.helper = GridHelper.create(tiles.width(),tiles.height());
  }

  public void print() {
    tiles.printToStandardOutput(this::toString);
  }

  private String toString(Position position, Tile tile) {
    if (tile != Tile.FLOOR) {
      return tile.displayed();
    }
    final var idx = helper.linearIndexFor(position);
    if (types[idx] == Type.O) {
      return "O";
    }
    return ".";
  }

  private boolean isOriginalPosition(Position position) {
    return (position.x()%2)==1 && (position.y()%2)==1;
  }

  public int countInside() {
    return (int)helper.allPositionOnGrid()
      .filter(this::isOriginalPosition)
      .mapToInt(helper::linearIndexFor)
      .filter(p -> types[p] == null).count();
  }


  public void fill() {
    final Set<Position> visited = new HashSet<>();
    final Deque<Position> toTest = new LinkedList<>();
    toTest.add(Position.of(0,0));

    while (!toTest.isEmpty()) {
      final var p = toTest.removeFirst();
      if (visited.contains(p) || !helper.isInside(p)) {
        continue;
      }

      visited.add(p);

      final var tile = tiles.get(p);
      if (tile != Tile.FLOOR) {
        continue;
      }

      types[helper.linearIndexFor(p)] = Type.O;

      ORIENTATIONS.forEach(o -> toTest.addLast(p.displaced(o)));
    }


  }

  public static Doubled create(Map map) {
    final var pair = map.cleaned();
    final var reference = pair.first();
    final var cycle = pair.second();
    final var width = reference.width();
    final var height = reference.height();
    final var w = width * 2 + 1;
    final var h = height * 2 + 1;


    final ToIntFunction<Position> toDoubleIndex = p -> p.x()*2+1+w*(p.y()*2+1);
    final UnaryOperator<Position> toDoublePosition = p -> Position.of(p.x()*2+1,(p.y()*2+1));


    final var newTiles = new Tile[w * h];
    Arrays.fill(newTiles,Tile.FLOOR);
    reference.forEach((p,v) -> newTiles[toDoubleIndex.applyAsInt(p)]=v);

    final var helper = GridHelper.create(w,h);
    final var types = new Type[newTiles.length];

    for (int i = 0; i < cycle.size(); i++) {
      final var j = (i+1)%cycle.size();

      final var pStart = toDoublePosition.apply(cycle.get(i));
      final var pEnd = toDoublePosition.apply(cycle.get(j));

      types[helper.linearIndexFor(pStart)] = Type.L;

      final var minX = Math.min(pEnd.x(),pStart.x());
      final var maxX = Math.max(pEnd.x(),pStart.x());
      final var minY = Math.min(pEnd.y(),pStart.y());
      final var maxY = Math.max(pEnd.y(),pStart.y());


      if (maxX == minX) {
        for (int y = minY+1; y < maxY ; y++) {
          newTiles[helper.linearIndexFor(minX,y)] = Tile.PIPE_V;
        }
      } else if (minY == maxY) {
        for (int x = minX+1; x < maxX ; x++) {
          newTiles[helper.linearIndexFor(x,minY)] = Tile.PIPE_H;
        }
      } else {
        throw new AOCException("Something wrong");
      }

    }



    return new Doubled(new BaseGenericArray<>(newTiles,w,h),types);
  }


}
