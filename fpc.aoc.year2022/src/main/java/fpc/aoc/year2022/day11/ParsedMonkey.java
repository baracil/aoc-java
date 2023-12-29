package fpc.aoc.year2022.day11;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;

@RequiredArgsConstructor
@Builder(builderClassName = "Builder")
public class ParsedMonkey {
  private final int index;
  private final int[] items;
  private final LongUnaryOperator operation;
  @Getter
  private final int divisor;
  private final int ifTrue;
  private final int ifFalse;


  public @NonNull Monkey createMonkey(@NonNull LongUnaryOperator postOperation) {
    return new Monkey(items,getItemOperation(postOperation),createThrowFunction());
  }

  private UnaryOperator<Item> getItemOperation(@NonNull LongUnaryOperator postOperation) {
    return item -> new Item(operation.andThen(postOperation).applyAsLong(item.worryLevel()));
  }

  private Function<Item,Throw> createThrowFunction() {
    return new ThrowFunction(divisor,ifTrue,ifFalse);
  }

  @RequiredArgsConstructor
  private static class ThrowFunction implements Function<Item,Throw> {
    private final int divisor;
    private final int ifTrue;
    private final int ifFalse;

    @Override
    public Throw apply(Item item) {
      final var monkeyIndex = (0 == item.worryLevel()%divisor)?ifTrue:ifFalse;
      return new Throw(item,monkeyIndex);
    }
  }

  public static class Builder {}
}
