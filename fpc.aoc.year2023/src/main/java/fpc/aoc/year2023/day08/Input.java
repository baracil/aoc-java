package fpc.aoc.year2023.day08;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class Input {

  private final boolean[] right;
  private final Map<String, Node> paths;


  public Stream<String> nodes() {
    return paths.keySet().stream();
  }

  public long part1() {
    return countSteps("AAA", "ZZZ"::equals);
  }

  public long countSteps(String start, Predicate<String> endTest) {
    final int length = right.length;
    var position = start;
    long count = 0;
    while (!endTest.test(position)) {
      final var r = right[(int) (count % length)];

      if (r) {
        position = paths.get(position).right();
      } else {
        position = paths.get(position).left();
      }
      count++;
    }
    return count;
  }


  public static Input parse(List<String> lines) {
    final var firstLine = lines.get(0);
    final var right = new boolean[firstLine.length()];

    for (int i = 0; i < firstLine.length(); i++) {
      right[i] = firstLine.charAt(i) == 'R';
    }

    Map<String, Node> paths = new HashMap<>();

    for (int i = 2; i < lines.size(); i++) {
      var tokens = lines.get(i).split("[ =,()]+");
      paths.put(tokens[0], new Node(tokens[1], tokens[2]));
    }

    return new Input(right, paths);
  }
}
