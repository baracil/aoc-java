package fpc.aoc.year2020.day6.structures;

import fpc.aoc.common.AOCException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupListBuilder {

  public static List<Group> build(List<String> input) {
    return new GroupListBuilder(input).build();
  }

  private final List<String> input;

  private final List<Group> listBuilder = new ArrayList<>();

  private GroupBuilder groupBuilder = null;

  public List<Group> build() {
    int i = 0;
    for (String line : input) {
      i++;
      try {
        if (line.isBlank()) {
          this.handleBlankLine();
        } else {
          this.handleNotBlankLine(line);
        }
      } catch (Exception e) {
        throw new AOCException("Could not parse line #" + i + " : '" + line + "'", e);
      }
    }
    this.appendBuilderInProgressToList();

    return listBuilder;
  }

  private void handleBlankLine() {
    this.appendBuilderInProgressToList();
  }

  private void handleNotBlankLine(String line) {
    this.createGroupBuilderIfNecessary();
    this.groupBuilder.addLine(line);
  }

  private void createGroupBuilderIfNecessary() {
    if (groupBuilder == null) {
      groupBuilder = Group.builder();
    }
  }

  private void appendBuilderInProgressToList() {
    if (groupBuilder != null) {
      listBuilder.add(groupBuilder.build());
      groupBuilder = null;
    }
  }

}
