package fpc.aoc.year2022.day16;

import fpc.aoc.common.IntPair;
import fpc.aoc.common.Tools;

import java.util.stream.Stream;

public class Valves {

  private final String[] names;
  private final int[] rates;
  private final int[][] distances;
  private final int[] masks;
  private final int allOpenedMask;

  public Valves(String[] names, int[] rates, int[][] distances) {
    this.names = names;
    this.rates = rates;
    this.distances = distances;
    this.masks = new int[names.length];
    int allOpened = 0;
    for (int i = 0; i < masks.length; i++) {
      masks[i] = 1 << i;
      allOpened |= masks[i];
    }
    this.allOpenedMask = allOpened;
  }

  public int mask(int valve) {
    return masks[valve];
  }

  public boolean allOpened(int valveStates) {
    return valveStates == allOpenedMask;
  }

  public int getNbValves() {
    return rates.length;
  }

  public String name(int valve) {
    return names[valve];
  }

  public int rate(int valve) {
    return rates[valve];
  }

  public int distances(int valve1, int valve2) {
    return distances[valve1][valve2];
  }

  public Stream<IntPair> generateBalancedPartitions() {
    final var nbValves = getNbValves();
    return Tools.generateWithNumberOfBitsAtOne(nbValves, nbValves / 2)
        .mapToObj(m -> new IntPair(m, (~m) & allOpenedMask));

  }

}
