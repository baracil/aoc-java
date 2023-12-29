package fpc.aoc.year2022.day5;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class Stacks {

  private final @NonNull List<Deque<String>> stacks;

  private Stacks(int nbStacks) {
    this.stacks = IntStream.range(0, nbStacks)
        .<Deque<String>>mapToObj(i -> new LinkedList<>())
        .toList();
  }

  public @NonNull String pick(int stackNumber) {
    return stacks.get(stackNumber-1).removeLast();
  }

  public void put(int stackNumber, @NonNull String crate) {
    stacks.get(stackNumber-1).addLast(crate);
  }

  public @NonNull String listTopOfStacks() {
    return stacks.stream()
        .map(Deque::peekLast)
        .filter(Objects::nonNull)
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

  public static @NonNull Stacks parse(@NonNull List<String> header) {
    final var lastIndex = header.size() - 1;
    final var indices = header.get(lastIndex);

    final var nbStacks = (indices.length() / 4)+1;

    final var stacks = new Stacks(nbStacks);

    for (String line : header.subList(0, lastIndex).reversed()) {
      for (int i = 1, j = 1; i < line.length(); i += 4, j++) {
        final var c = line.charAt(i);
        if (c != ' ') {
          stacks.put(j,String.valueOf(c));
        }
      }
    }

    return stacks;
  }

}
