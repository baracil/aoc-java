package fpc.aoc.year2022.day10;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Crt {

  private final char[] display;

  public Crt() {
    this.display = new char[40 * 6];
    Arrays.fill(display, ' ');
  }

  public void drawPixel(int cycle) {
    this.display[cycle - 1] = '█';
  }

  public String dumpDisplay() {
    return IntStream.range(0, 6)
        .mapToObj(lineIdx -> new String(display, lineIdx * 40, 40))
        .collect(Collectors.joining("\n","\n","\n"));
  }
}
