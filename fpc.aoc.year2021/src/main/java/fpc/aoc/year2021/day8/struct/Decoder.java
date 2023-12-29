package fpc.aoc.year2021.day8.struct;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Decoder {

  public static @NonNull WiringInfo<Integer> decode(@NonNull WiringInfo<String> encoded) {
    return new Decoder(encoded).decode();
  }

///                a b c d e f g
/// a_6+a_5-4*a_3  2 4 0 5 3 1 6
//        a b c d e f g
  // 0  1 1 1 0 1 1 1
  // 1  0 0 1 0 0 1 0
  // 2  1 0 1 1 1 0 1
  // 3  1 0 1 1 0 1 1
  // 4  0 1 1 1 0 1 0
  // 5  1 1 0 1 0 1 1
  // 6  1 1 0 1 1 1 1
  // 7  1 0 1 0 0 1 0
  // 8  1 1 1 1 1 1 1
  // 9  1 1 1 1 0 1 1

  private static int[] BITMASK = {4, 32, 1, 16, 2, 8, 64};
  private static Map<Integer, Integer> DIGIT_MAPPER = Map.of(
      36, 1,
      93, 2,
      109, 3,
      46, 4,
      107, 5,
      123, 6,
      37, 7,
      127, 8,
      111, 9,
      119, 0);


  private final WiringInfo<String> encoded;
  private final int[] histogram = new int[7];

  private List<Integer> numbers;
  private List<Integer> digits;

  private @NonNull WiringInfo<Integer> decode() {
    this.computeHistogram();
    this.decodeNumbers();
    this.decodeDigits();

    return new WiringInfo<>(numbers, digits);
  }

  private void decodeNumbers() {
    numbers = decode(encoded.numbers());
  }

  private void decodeDigits() {
    digits = decode(encoded.digits());
  }

  private @NonNull List<Integer> decode(@NonNull List<String> encodedNumbers) {
    return encodedNumbers.stream().map(this::decodeNumber).toList();
  }

  private void computeHistogram() {
    encoded.numbers().forEach(this::addToHistogram);
  }

  private void addToHistogram(@NonNull String number) {
    final var weight = switch (number.length()) {
      case 3 -> -4;
      case 5, 6 -> 1;
      default -> 0;
    };
    if (weight != 0) {
      number.chars()
          .map(c -> c - 'a')
          .forEach(i -> histogram[i] += weight);
    }
  }

  private int decodeNumber(String number) {
    final var value = number.chars()
        .map(c -> c - 'a')
        .map(i -> histogram[i])
        .map(i -> BITMASK[i])
        .sum();
    return DIGIT_MAPPER.get(value);
  }

}
