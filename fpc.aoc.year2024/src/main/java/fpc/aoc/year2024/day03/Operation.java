package fpc.aoc.year2024.day03;

public sealed interface Operation {

  record Mult(int left, int right) implements Operation {
  }

  record Do() implements Operation {
  }

  record Dont() implements Operation {
  }
}
