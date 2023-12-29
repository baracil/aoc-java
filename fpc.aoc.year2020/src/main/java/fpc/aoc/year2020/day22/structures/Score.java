package fpc.aoc.year2020.day22.structures;

import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Score extends Number {

  public static @NonNull Score of(int value) {
    return new Score(value);
  }

  public static Score NAS = new Score(-1);

  int value;

  public Score(@NonNull List<Integer> cards) {
    int score = 0;
    int factor = cards.size();
    for (Integer card : cards) {
      score += card * factor;
      factor--;
    }
    value = score;
  }

  @Override
  public int intValue() {
    return value;
  }

  @Override
  public long longValue() {
    return value;
  }

  @Override
  public float floatValue() {
    return value;
  }

  @Override
  public double doubleValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
