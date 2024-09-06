package fpc.aoc.year2019.day17._private;

import fpc.aoc.common.AOCException;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PathBreaker {

  public static MovementRules breakPath(@NonNull Path path) {
    return new PathBreaker(path.toTokens()).breakPath();
  }


  private final String[] tokens;

  public MovementRules breakPath() {
    final MovementRules rules = breakPath(0, new Context());
    if (rules == null) {
      throw new AOCException("Could not break path");
    }
    return rules;
  }

  public MovementRules breakPath(int idx, Context context) {
    if (idx >= tokens.length) {
      return context.createRules();
    }
    if (!context.canAddMoreFunction()) {
      return null;
    }

    MovementRules rules;
    final int nbOrders = context.orderIdx;
    for (int i = 0; i < nbOrders; i++) {
      final Order order = context.orders[i];
      if (order.isPresentAt(idx)) {
        context.addFunction(order.function);
        try {
          rules = breakPath(idx + order.nbTokens(), context);
          if (rules != null) {
            return rules;
          }
        } finally {
          context.removeLastFunction();
        }
      }
    }

    if (!context.canAddMoreOrder()) {
      return null;
    }

    for (int i = idx + 1; i <= tokens.length; i++) {
      final Order order = context.addOrder(idx, i);
      if (order.commandLength() > 20) {
        context.removeLastOrder();
        return null;
      }

      context.addFunction(order.function);
      try {
        rules = breakPath(idx + order.nbTokens(), context);
        if (rules != null) {
          return rules;
        }
      } finally {
        context.removeLastFunction();
        context.removeLastOrder();
      }
    }
    return null;
  }

  private class Context {

    private final MovementFunction[] functions = MovementFunction.values();

    private final Order[] orders;

    private int orderIdx = 0;

    private final Deque<MovementFunction> functions1 = new LinkedList<>();

    public boolean canAddMoreOrder() {
      return orderIdx < orders.length;
    }

    public boolean canAddMoreFunction() {
      return functions1.size() < 10;
    }

    public Context() {
      this.orders = new Order[functions.length];
    }

    public void addFunction(MovementFunction fct) {
      functions1.addLast(fct);
    }

    public void removeLastFunction() {
      functions1.removeLast();
    }

    @NonNull
    public Order addOrder(int start, int end) {
      final Order order = new Order(functions[orderIdx], start, end);
      orders[orderIdx] = order;
      orderIdx++;
      return order;
    }

    public void removeLastOrder() {
      orders[--orderIdx] = null;
    }

    @NonNull
    private MovementRules createRules() {
      final Map<MovementFunction, String> routines = Arrays.stream(orders, 0, orderIdx)
          .collect(Collectors.toUnmodifiableMap(o -> o.function, Order::toRoutine));

      return new MovementRules(List.copyOf(functions1), routines);
    }

  }


  @RequiredArgsConstructor
  private class Order {

    private final MovementFunction function;

    private final int start;

    private final int end;

    public int nbTokens() {
      return end - start;
    }

    public String toRoutine() {
      return Arrays.stream(tokens, start, end).collect(Collectors.joining(","));
    }

    @Override
    public String toString() {
      return toRoutine();
    }

    public int commandLength() {
      return toRoutine().length();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Order)) {
        return false;
      }
      Order order = (Order) o;
      if (end - start != order.end - order.start) {
        return false;
      }

      return IntStream.range(0, end - start).allMatch(i -> tokens[i + start].equals(tokens[i + order.start]));
    }

    @Override
    public int hashCode() {
      int result = (end - start);

      for (int i = end; i < start; i++) {
        result = 31 * result + tokens[i].hashCode();
      }

      return result;
    }

    public boolean isPresentAt(int idx) {
      if (idx + (end - start) > tokens.length) {
        return false;
      }
      for (int i = start, j = idx; i < end; i++, j++) {
        if (!tokens[i].equals(tokens[j])) {
          return false;
        }
      }
      return true;
    }
  }

}
