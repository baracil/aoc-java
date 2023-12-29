package fpc.aoc.year2022.day22;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Day22Solver extends SmartSolver<Input22> {

  private final NavigationFactory navigationFactory;

  @Override
  protected @NonNull Converter<Input22> getConverter() {
    return lst -> Input22.parse(lst, navigationFactory);
  }


  @Override
  public @NonNull Long doSolve(@NonNull Input22 input) {
    var player = input.map().start();
    for (Order order : input.orders()) {
      player = order.apply(player, input.map());
    }
    return (long) player.getValue();
  }

}
