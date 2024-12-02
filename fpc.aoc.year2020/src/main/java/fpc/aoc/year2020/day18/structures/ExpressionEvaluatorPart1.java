package fpc.aoc.year2020.day18.structures;

import fpc.aoc.common.AOCException;

import java.util.Deque;

public class ExpressionEvaluatorPart1 implements ExpressionEvaluator {

  @Override
  public long getFinalResultFromQueue(Deque<Token> tokenQueue) {
    final Token lastToken = tokenQueue.poll();
    if (!tokenQueue.isEmpty() || lastToken == null || lastToken.type() != TokenType.NUMBER) {
      throw new AOCException("Invalid queue state to extract final result");
    }
    return lastToken.value();
  }

  @Override
  public boolean performOnePass(Deque<Token> tokenQueue) {
    if (tokenQueue.size() < 3) {
      return false;
    }
    var last = tokenQueue.peek();

    return switch (last.type()) {
      case OPEN_PARENTHESIS, ADD, MULTIPLY -> false;
      case CLOSING_PARENTHESIS -> this.evaluateSubExpression(tokenQueue);
      case NUMBER -> this.evaluateWithNumber(tokenQueue);
    };
  }

  private boolean evaluateSubExpression(Deque<Token> tokenQueue) {
    if (tokenQueue.size() < 3) {
      throw new AOCException("Queue too small for sub expression");
    }
    final var closingPar = tokenQueue.poll();
    final var number = tokenQueue.poll();
    final var openPar = tokenQueue.poll();
    if (number.type() != TokenType.NUMBER) {
      throw new AOCException("a number was expected as second token in the queue");
    }
    tokenQueue.offerFirst(number);
    return true;
  }

  private boolean evaluateWithNumber(Deque<Token> tokenQueue) {
    if (tokenQueue.size() < 3) {
      throw new AOCException("Queue too small for number evaluation");
    }
    final var third = tokenQueue.poll();
    final var second = tokenQueue.poll();
    final var first = tokenQueue.poll();
    if (second.isOperation()) {
      tokenQueue.offerFirst(second.operate(first, third));
      return true;
    } else {
      tokenQueue.offerFirst(first);
      tokenQueue.offerFirst(second);
      tokenQueue.offerFirst(third);
      return false;
    }
  }

}
