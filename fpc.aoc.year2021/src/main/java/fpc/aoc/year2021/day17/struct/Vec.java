package fpc.aoc.year2021.day17.struct;


public record Vec(int x, int y) {

  public static final Vec ZERO = new Vec(0, 0);

  public Vec add(Vec other) {
    return new Vec(this.x + other.x, this.y + other.y);
  }

  public Vec updatedVelocity() {
    return new Vec(x + Integer.compare(0, x), y - 1);
  }
}
