package fpc.aoc.year2020.day18.structures;

import java.util.Deque;

public interface ExpressionEvaluator {

  boolean performOnePass(Deque<Token> tokens);

  long getFinalResultFromQueue(Deque<Token> tokens);
}
