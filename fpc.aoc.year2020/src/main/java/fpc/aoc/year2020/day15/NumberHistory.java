package fpc.aoc.year2020.day15;

public class NumberHistory {

  private final int number;

  private int lastTurn;

  private int oneBeforeLastTurn;

  public NumberHistory(int number, int turn) {
    this.number = number;
    this.lastTurn = turn;
    this.oneBeforeLastTurn = turn;
  }

  public int getNextToSay() {
    return lastTurn - oneBeforeLastTurn;
  }

  public void setLastSpokenTurn(int turn) {
    this.oneBeforeLastTurn = this.lastTurn;
    this.lastTurn = turn;
  }

  @Override
  public String toString() {
    return "NumberHistory{" + number + " | " + lastTurn + " - " + oneBeforeLastTurn + '}';
  }
}
