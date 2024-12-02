package fpc.aoc.year2020.day18.structures;

import fpc.aoc.common.AOCException;
import lombok.RequiredArgsConstructor;

import java.util.Deque;
import java.util.LinkedList;

@RequiredArgsConstructor
public class ExprEvaluatorTemplate {

  private final ExpressionEvaluator expressionEvaluator;

  public long evaluate(String expressionAsString) {
    return new Execution(expressionAsString).evaluate();
  }

  private class Execution {

    private final String expressionAsString;
    private final ExpressionParser parser;
    private final Deque<Token> tokenQueue = new LinkedList<>();

    private Token currentToken = null;

    public Execution(String expressionAsString) {
      this.expressionAsString = expressionAsString;
      this.parser = new ExpressionParser(expressionAsString);
    }


    public long evaluate() {

      do {
        this.getNextToken();
        if (expressionIsDone()) {
          return getResultFromQueue();
        } else {
          tokenQueue.offerFirst(currentToken);
          this.evaluateQueue();
        }
      } while (true);
    }

    private void getNextToken() {
      currentToken = parser.getNextToken().orElse(null);
    }

    private boolean expressionIsDone() {
      return currentToken == null;
    }

    private long getResultFromQueue() {
      return expressionEvaluator.getFinalResultFromQueue(tokenQueue);
    }


    private void evaluateQueue() {
      while (expressionEvaluator.performOnePass(tokenQueue)) ;
    }

    private AOCException createParsingException() {
      throw new AOCException("Fail to evaluate expression : '" + expressionAsString + "'");
    }
  }


}
