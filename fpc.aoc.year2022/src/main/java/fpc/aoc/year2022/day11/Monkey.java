package fpc.aoc.year2022.day11;

import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Monkey {

  private final Deque<Item> items;
  private final UnaryOperator<Item> operation;
  private final Function<Item, Throw> throwFunction;

  public Monkey(int[] items, UnaryOperator<Item> operation, Function<Item, Throw> throwFunction) {
    this.items = new LinkedList<>();
    Arrays.stream(items).mapToObj(Item::new).forEach(this.items::addLast);
    this.operation = operation;
    this.throwFunction = throwFunction;
  }

  public List<Throw> inspect() {
    final List<Throw> throwBuild = new ArrayList<>();
    while (true) {
      final var item = items.pollFirst();
      if (item == null) {
        return throwBuild;
      }
      final var inspectedItem = operation.apply(item);
      throwBuild.add(throwFunction.apply(inspectedItem));
    }
  }

  public void catchItem(Item item) {
    this.items.addLast(item);
  }

  @Override
  public String toString() {
    return "Monkey{" + items + '}';
  }
}
