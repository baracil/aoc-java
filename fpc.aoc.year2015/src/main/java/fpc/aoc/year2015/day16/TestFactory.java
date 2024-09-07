package fpc.aoc.year2015.day16;

import java.util.function.IntPredicate;

public interface TestFactory {

  IntPredicate create(String name, int value);


  record Part1() implements TestFactory {
    @Override
    public IntPredicate create(String name, int value) {
      return new Equal(value);
    }
  }


  record Part2() implements TestFactory {
    @Override
    public IntPredicate create(String name, int value) {
      return switch (name) {
        case "cats", "trees" -> new GreaterThan(value);
        case "pomeranians", "goldfish" -> new LowerThan(value);
        default -> new Equal(value);
      };
    }
  }


  record GreaterThan(int value) implements IntPredicate {
    @Override
    public boolean test(int value) {
      return value > this.value;
    }
  }

  record LowerThan(int value) implements IntPredicate {
    @Override
    public boolean test(int value) {
      return value < this.value;
    }
  }

  record Equal(int value) implements IntPredicate {
    @Override
    public boolean test(int value) {
      return value == this.value;
    }
  }

}
