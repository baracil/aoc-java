package fpc.aoc.year2020.day18.structures;

import lombok.NonNull;

import java.util.Deque;

public interface ExpressionEvaluator {

    boolean performOnePass(@NonNull Deque<Token> tokens);

    long getFinalResultFromQueue(@NonNull Deque<Token> tokens);
}
