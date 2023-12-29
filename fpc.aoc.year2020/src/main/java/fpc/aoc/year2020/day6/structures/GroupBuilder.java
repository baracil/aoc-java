package fpc.aoc.year2020.day6.structures;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Tools;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class GroupBuilder {

  private final @NonNull List<Person> personBuilder = new ArrayList<>();

  public void addLine(@NonNull String line) {
    if (line.isBlank()) {
      throw new AOCException("Invalid blank line while building a group");
    }
    final var questions = line.chars()
        .mapToObj(Question::parse)
        .collect(Tools.enumSetCollector(Question.class));
    personBuilder.add(new Person(questions));
  }

  public @NonNull Group build() {
    return new Group(personBuilder);
  }
}
