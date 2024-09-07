package fpc.aoc.year2015.day16;

import lombok.Value;

import java.util.HashMap;
import java.util.Map;

//Sue 1: cars: 9, akitas: 3, goldfish: 0
@Value
public class Sue {
  String index;
  Map<String,Integer> characteristics;


  public static Sue parse(String line) {
    final var tokens = line.split("[,: ]+");
    final var index = tokens[1];
    final Map<String,Integer> characteristics = new HashMap<>();
    for (int i = 2; i < tokens.length; i+=2) {
      characteristics.put(tokens[i],Integer.parseInt(tokens[i+1]));
    }

    return new Sue(index,characteristics);
  }
}
