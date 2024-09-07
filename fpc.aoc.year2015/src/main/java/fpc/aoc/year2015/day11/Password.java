package fpc.aoc.year2015.day11;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Password {

  public static Password of(String password) {
    return new Password(IntStream.range(0,8)
      .map(password::charAt)
      .map(i -> i-'a')
      .toArray());
  }

  public static final int I = 'i'-'a';
  public static final int O = 'o'-'a';
  public static final int L = 'l'-'a';

  private final int[] digits;

  public void increment() {
    int i = digits.length-1;
    while (i >=0) {
      digits[i]++;
      if (digits[i] != 26) {
        break;
      }
      digits[i] = 0;
      i--;
    }
  }

  @Override
  public String toString() {
    return Arrays.stream(digits).mapToObj(i -> String.valueOf((char)(i + 'a'))).collect(Collectors.joining());
  }

  public boolean isValid() {
    return noForbiddenLetters() && hasStraight() && repeat();
  }

  private boolean hasStraight() {
    for (int i = 0; i < digits.length - 2; i++) {
      int nb = 0;
      for (int j = 1, k = i + 1; j < 3; j++, k++) {
        if (digits[k - 1] +1 != digits[k] ) {
          break;
        }
        nb++;
      }
      if (nb == 2) {
        return true;
      }
    }
    return false;
  }

  private boolean repeat() {
    int d = -1;
    int i = 0;
    while (i < digits.length-1) {
      if (digits[i] == digits[i + 1]) {
        if (d<0) {
          d = digits[i];
        }
        else if (digits[i] != d) {
          return true;
        }
        i+=2;
      } else {
        i+=1;
      }
    }
    return false;
  }

  private boolean noForbiddenLetters() {
    for (final int d : digits) {
      if(d == I || d== O || d == L) {
        return false;
      }
    }
    return true;
  }


}
