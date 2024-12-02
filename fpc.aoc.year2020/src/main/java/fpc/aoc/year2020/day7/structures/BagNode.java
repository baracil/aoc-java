package fpc.aoc.year2020.day7.structures;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
@EqualsAndHashCode(of = {"color"})
public class BagNode {

  @Getter
  private final String color;

  @Getter private final Set<BagNode> containers = new HashSet<>();

  private final Map<BagNode, Integer> content = new HashMap<>();

  public void addToContent(BagNode contained, int quantity) {
    content.put(contained, quantity);
    contained.containers.add(this);
  }

  public Map<BagNode, Integer> getContent() {
    return Collections.unmodifiableMap(content);
  }

}
