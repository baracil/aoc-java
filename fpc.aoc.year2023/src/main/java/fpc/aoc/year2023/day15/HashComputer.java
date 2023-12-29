package fpc.aoc.year2023.day15;

public class HashComputer {

  public int compute(String value) {
    return value.chars().reduce(0,(hash,chr) -> ((hash+chr)*17)&0xFF);
  }

}
