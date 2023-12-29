package fpc.aoc.year2022.day11;

import fpc.aoc.common.Top;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class MonkeyGame {

  private final List<Monkey> monkeys;

  @Getter
  private final int[] nbInspection;

  public MonkeyGame(List<Monkey> monkeys) {
    this.monkeys = monkeys;
    this.nbInspection = new int[monkeys.size()];
  }

  public void performOneTurn() {

    for (int i = 0; i < monkeys.size(); i++) {
      final var monkey = monkeys.get(i);
      final var thrownItems = monkey.inspect();

      nbInspection[i] += thrownItems.size();

      for (Throw thrownItem : thrownItems) {
        monkeys.get(thrownItem.monkeyIndex()).catchItem(thrownItem.item());
      }
    }
  }
  
  public long getMonkeyBusiness() {
    final var top = new Top(2);
    Arrays.stream(nbInspection).forEach(top::handle);
    return top.product();
  }
}
