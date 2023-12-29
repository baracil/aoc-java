package fpc.aoc.year2020.day6.structures;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.EnumSet;
import java.util.stream.Stream;

@RequiredArgsConstructor
@ToString
public class Person {

    private final @NonNull EnumSet<Question> questions;

    public int getNumberOfQuestions() {
        return questions.size();
    }

    public @NonNull Stream<Question> questionStream() {
        return questions.stream();
    }

    public boolean doesNotHaveTheQuestion(@NonNull Question question) {
        return !questions.contains(question);
    }
}
