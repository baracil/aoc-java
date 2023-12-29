package fpc.aoc.year2022.day22;

import fpc.aoc.common.ArrayOfChar;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Getter
public class Input22 {

  private final Map map;
  private final List<Order> orders;


  private static final Pattern PATTERN = Pattern.compile("(?<length>[0-9]+)(?<op>[LRF])");

  public static Input22 parse(List<String> lines, @NonNull NavigationFactory navigationFactory) {
    final var idx = IntStream.range(0, lines.size()).filter(i -> lines.get(i).isEmpty()).findAny().orElseThrow();
    final var map = ArrayOfChar.from(lines.subList(0, idx), ' ');

    final List<Order> list = new ArrayList<>();
    final var l = lines.get(idx + 1) + "F";
    final var matcher = PATTERN.matcher(l);
    while (matcher.find()) {
      list.add(new Order.Move(Integer.parseInt(matcher.group("length"))));
      switch (matcher.group("op")) {
        case "R" -> list.add(new Order.RotateR());
        case "L" -> list.add(new Order.RotateL());
      }
    }

    return new Input22(new Map(map, navigationFactory.create(map)), list);
  }
}
