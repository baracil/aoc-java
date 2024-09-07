package fpc.aoc.year2015.day12;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.UncheckedIOException;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public abstract class Day12Solver extends SmartSolver<Object> {

  @Override
  protected @NonNull Converter<Object> getConverter() {
    return Converter.FIRST_LINE.andThen(line -> {
      final var o = new ObjectMapper();
      try {
        return o.readValue(line,Object.class);
      } catch (JsonProcessingException e) {
        throw new UncheckedIOException(e);
      }
    });
  }

  protected abstract Predicate<Map<?,?>> getIgnoredPredicate();

  @Override
  public @NonNull Integer doSolve(@NonNull Object input) {
    final var summer = new Summer(getIgnoredPredicate());

    return summer.sum(input);
  }

  @RequiredArgsConstructor
  private static class Summer {

    private final Predicate<Map<?,?>> ignored;

    private int sum(Object input) {
      if (input instanceof List<?> list) {
        return list.stream().mapToInt(this::sum).sum();
      } else if (input instanceof Map<?,?> object) {
        if(ignored.test(object)) {
          return 0;
        }
        return object.values().stream().mapToInt(this::sum).sum();
      } else if (input instanceof Number n) {
        return n.intValue();
      }
      return 0;
    }

  }


}
