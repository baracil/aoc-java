package fpc.aoc.year2020.day6.structures;

import fpc.aoc.common.LazyInt;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.EnumSet;
import java.util.List;

@RequiredArgsConstructor
@ToString
public class Group {

  private final List<Person> people;

  private final LazyInt numberOfDistinctQuestions = new LazyInt(this::countDistinctQuestions);
  private final LazyInt numberOfCommonQuestions = new LazyInt(this::countCommonQuestions);

  public static GroupBuilder builder() {
    return new GroupBuilder();
  }

  public int getNumberOfDistinctQuestions() {
    return numberOfDistinctQuestions.intValue();
  }

  public int getNumberOfCommonQuestions() {
    return numberOfCommonQuestions.intValue();
  }

  private int countDistinctQuestions() {
    return Math.toIntExact(people.stream()
        .flatMap(Person::questionStream)
        .distinct()
        .count());
  }

  private int countCommonQuestions() {
    if (people.size() == 0) {
      return 0;
    }
    final EnumSet<Question> common = EnumSet.allOf(Question.class);
    for (Person person : people) {
      common.removeIf(person::doesNotHaveTheQuestion);
    }

    return common.size();
  }

}
