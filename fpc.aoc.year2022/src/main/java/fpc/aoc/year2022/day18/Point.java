package fpc.aoc.year2022.day18;

import lombok.NonNull;

public record Point(int x, int y, int z) {


  public @NonNull Point add(@NonNull Disp disp) {
    return new Point(x+disp.dx(),y+disp.dy(),z+disp.dz());
  }
  
  @Override
  public String toString() {
    return "Point{" + x*0.5 + ", " + y*0.5 +", " + z*0.5 +
        '}';
  }
}
