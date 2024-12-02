package fpc.aoc.year2020.day7.structures;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BagGraphBuilder {

  public static BagGraph build(List<String> lines) {
    return new BagGraphBuilder(lines).build();
  }

  private final List<String> lines;

  private final Map<String, BagNode> nodes = new HashMap<>();

  private BagGraph build() {
    for (String line : lines) {
      handleOneLine(line);
    }
    return new BagGraph(Map.copyOf(nodes));
  }

  private void handleOneLine(String line) {
    final var parsing = OneLineParser.parse(line);
    final var container = getBagNodeFromColorName(parsing.colorName());

    for (var entry : parsing.content().entrySet()) {
      final var contained = getBagNodeFromColorName(entry.getKey());
      container.addToContent(contained, entry.getValue());
    }
  }

  private BagNode getBagNodeFromColorName(String colorName) {
    return nodes.computeIfAbsent(colorName, BagNode::new);
  }

}
