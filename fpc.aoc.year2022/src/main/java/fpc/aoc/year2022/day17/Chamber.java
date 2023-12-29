package fpc.aoc.year2022.day17;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Position;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Chamber {

  private final ArrayList<Level> levels = new ArrayList<>();
  @Getter
  private int highestRock;

  public Chamber() {
    this.levels.add(Level.full());
    this.highestRock = 0;
  }

  public @NonNull Position getStartingPosition() {
    return Position.of(2,highestRock+4);
  }


  public @NonNull Snapshot peekSnapshot(@NonNull ShapeType shapeType, int jetIndex) {
    final int top = highestRock;
    int idx = top;

    while (idx >= 0) {
      final var l = levels.get(idx);
      if (l.stop(shapeType)) {
        return new Snapshot(IntStream.rangeClosed(idx,top).map(i -> levels.get(i).rocks).toArray(),shapeType,jetIndex);
      }
      idx--;
    }
    throw new AOCException("SHOULD NOT HAPPEN");
  }

  public boolean isEmpty(int x, int y) {
    if (x < 0 || x >=7 ) {
      return false;
    }

    if (y >= levels.size()) {
      return true;
    }
    return !levels.get(y).isRock(x);
  }

  public void putShape(Shape shape) {
    shape.rockPositions().forEach(this::putRock);
  }

  private void putRock(Position p) {
    final var y = p.y();
    final var x = p.x();
    final var level = getOrCreateLevel(y);

    highestRock = Math.max(highestRock,y);
    level.setRock(x);
  }

  private Level getOrCreateLevel(int levelIdx) {
    while (levels.size() <= levelIdx) {
      levels.add(Level.empty());
    }
    return levels.get(levelIdx);

  }


  private static class Level {
    private int rocks;

    public Level(int rocks) {
      this.rocks = rocks;
    }

    public static Level empty() {
      return new Level(0);
    }
    public static Level full() {
      return new Level(127);
    }

    @Override
    public String toString() {
      return IntStream.range(0, 7)
          .map(i -> 1<<(6-i))
          .mapToObj(i -> (rocks&i)==0 ? "." : "#").collect(Collectors.joining());
    }

    private boolean notMatch(int mask) {
      return (rocks & mask) != 0;
    }

    public boolean stop(ShapeType shapeType) {
      return switch (shapeType) {
        case HBAR -> stopHBar();
        case VBAR -> stopVBar();
        case CROSS -> stopCross();
        case CORNER -> stopCorner();
        case SQUARE -> stopSquare();
      };
    }

    public boolean stopHBar() {
      return notMatch(0b0000111) && notMatch(0b1000011) && notMatch(0b1100001) && notMatch(0b1110000);
    }

    public boolean stopVBar() {
      return rocks == 0b1111111;
    }

    public boolean stopCross() {
      return notMatch(0b0111111)
          && notMatch(0b1011111)
          && notMatch(0b1101111)
          && notMatch(0b1110111)
          && notMatch(0b1111011)
          && notMatch(0b1111101)
          && notMatch(0b1111110)
          ;
    }

    public boolean stopSquare() {
      return notMatch(0b0011111)
          && notMatch(0b1001111)
          && notMatch(0b1100111)
          && notMatch(0b1110011)
          && notMatch(0b1111001)
          && notMatch(0b1111100)
          ;
    }

    public boolean stopCorner() {
      return notMatch(0b0001111)
          && notMatch(0b1000111)
          && notMatch(0b1100011)
          && notMatch(0b1110001)
          && notMatch(0b1111000)
          ;
    }

    public void setRock(int x) {
      final var s = 1<<x;
      this.rocks |=s;
    }

    public boolean isRock(int x) {
      return (rocks&(1<<x)) !=0;
    }
  }

}
