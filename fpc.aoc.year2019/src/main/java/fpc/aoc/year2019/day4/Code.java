package fpc.aoc.year2019.day4;

import lombok.NonNull;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Code implements Comparable<Code> {

    @NonNull
    public static Code create(String code) {
        return new Code(code);
    }

    @NonNull
    public static Code normalized(String code) {
        return new Code(code).normalize();
    }

    private final int[] digits;

    private Code(String first) {
        this.digits = IntStream.range(0,first.length())
                               .map(i -> Integer.parseInt(first.substring(i,i+1)))
                               .toArray();
    }

    @NonNull
    public Code normalize() {
        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] > digits[i+1]) {
                Arrays.fill(digits,i,digits.length,digits[i]);
                break;
            }
        }
        return this;
    }

    public boolean hasTwoIdenticalConsecutiveDigits() {
        for (int i = 0; i < digits.length-1; i++) {
            if (digits[i] == digits[i+1]) {
                return true;
            }
        }
        return false;
    }

    public boolean hasTwoIsolateIdenticalConsecutiveDigits() {
        int current = digits[0];
        int currentCount = 1;
        for (int i = 1; i < digits.length; i++) {
            if (current == digits[i]) {
                currentCount++;
            }
            else if (currentCount == 2) {
                return true;
            }
            else {
                current = digits[i];
                currentCount = 1;
            }
        }
        return currentCount == 2;
    }


    public boolean moveToNextCodeWithIncreasingDigit() {
        int counter = digits.length-1;
        do {
            int value = digits[counter]+1;
            if (value >= 10 && counter == 0) {
                return false;
            }
            if (value >= 10) {
                counter--;
            } else {
                for (int i = counter; i < digits.length ; i++) {
                    digits[i] = value;
                }
                return true;
            }
        } while (true);
    }

    @Override
    public String toString() {
        return Arrays.stream(digits).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    @Override
    public int compareTo(Code code) {
        int result = 0;
        for (int i = 0; i < digits.length && result == 0; i++) {
            result = this.digits[i] - code.digits[i];
        }
        return result;
    }
}
