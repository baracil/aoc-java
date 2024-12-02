package fpc.aoc.year2021.day12.struct;

import lombok.*;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(of = "name")
@ToString(of = {"name"})
public class Node {

  public static Node create(String name) {
    if (name.equals("start")) {
      return new Node(name, true, false, false, false);
    } else if (name.equals("end")) {
      return new Node(name, false, true, false, false);
    } else if (name.toUpperCase().equals(name)) {
      return new Node(name, false, false, false, true);
    } else {
      return new Node(name, false, false, true, false);
    }
  }

  private final String name;
  private final boolean start;
  private final boolean end;
  private final boolean smallCave;
  private final boolean bigCave;


}
