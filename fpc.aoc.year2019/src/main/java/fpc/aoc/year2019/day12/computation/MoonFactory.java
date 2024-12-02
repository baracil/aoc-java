package fpc.aoc.year2019.day12.computation;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class MoonFactory {

  @NonNull
  public static List<Moon> createMoons(List<String> input) {
    return new MoonFactory(input).create();
  }

  @NonNull
  private final List<String> input;

  @NonNull
  public List<Moon> create() {
    return IntStream.range(0, input.size())
        .mapToObj(this::createMoon)
        .toList();
  }

  @NonNull
  private Moon createMoon(int index) {
    final Vector position = Vector.parse(input.get(index));
    return Moon.create(position);
  }

}
