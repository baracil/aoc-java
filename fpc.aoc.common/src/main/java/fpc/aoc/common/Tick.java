package fpc.aoc.common;

public class Tick {

  private long time;

  public Tick tick() {
    this.time = System.nanoTime();
    return this;
  }

  public void tack(String label) {
    final var old = this.time;
    tick();
    System.out.format("%s : %.3f%n", label, (this.time - old) * 1e-6);
    tick();
  }
}
