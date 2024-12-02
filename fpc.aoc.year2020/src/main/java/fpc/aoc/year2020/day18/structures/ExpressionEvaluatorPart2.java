package fpc.aoc.year2020.day18.structures;

import fpc.aoc.common.AOCException;

import java.util.Deque;

public class ExpressionEvaluatorPart2 implements ExpressionEvaluator {

  @Override
  public long getFinalResultFromQueue(Deque<Token> tokens) {
    return tokens.stream()
        .filter(n -> n.type() == TokenType.NUMBER)
        .mapToLong(Token::value)
        .reduce(1, (l1, l2) -> l1 * l2);
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
    tokenQueue.poll();
    long product = 1;

    do {
      var token = tokenQueue.poll();
      if (token == null) {
        throw new AOCException("Unexpected end of sub expression evaluation");
      }
      if (token.type() == TokenType.OPEN_PARENTHESIS) {
        tokenQueue.offerFirst(Token.number(product));
        return true;
      } else if (token.type() == TokenType.MULTIPLY) {
        continue;
      } else if (token.type() == TokenType.NUMBER) {
        product *= token.value();
      } else {
        throw new AOCException("Unexpected token '" + token.type() + "' in sub expression evaluation");
      }
    } while (true);
  }

  private boolean evaluateWithNumber(Deque<Token> tokenQueue) {
    if (tokenQueue.size() < 3) {
      throw new AOCException("Queue too small for number evaluation");
    }
    final var third = tokenQueue.poll();
    final var second = tokenQueue.poll();
    final var first = tokenQueue.poll();

    if (second.type() == TokenType.ADD) {
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
