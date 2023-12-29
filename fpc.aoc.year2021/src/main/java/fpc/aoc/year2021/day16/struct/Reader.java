package fpc.aoc.year2021.day16.struct;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Map;
import java.util.stream.Collectors;

import static fpc.aoc.common.ImmutableEntry.of;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Reader {

  private final @NonNull String message;
  private final int end;
  private int index;

  public static @NonNull Reader fromHexaString(String hexaPacket) {
    final var binPacket = hexaPacket.chars().mapToObj(HEX_TO_BIN_DIGITS::get).collect(Collectors.joining());
    return new Reader(binPacket, binPacket.length(), 0);
  }

  public int read(int nbBits) {
    final var pos = move(nbBits);
    return Integer.parseInt(message.substring(pos, this.index), 2);
  }

  public @NonNull Reader extract(int length) {
    final var pos = move(length);
    return new Reader(message, this.index, pos);
  }

  private int move(int nbBits) {
    if (index + nbBits > end) {
      throw new IndexOutOfBoundsException();
    }
    final var pos = index;
    this.index += nbBits;
    return pos;
  }

  public int remaining() {
    return end - index;
  }


  private static final Map<Integer, String> HEX_TO_BIN_DIGITS = Map.ofEntries(
      of('0' + 0, "0000"),
      of('1' + 0, "0001"),
      of('2' + 0, "0010"),
      of('3' + 0, "0011"),
      of('4' + 0, "0100"),
      of('5' + 0, "0101"),
      of('6' + 0, "0110"),
      of('7' + 0, "0111"),
      of('8' + 0, "1000"),
      of('9' + 0, "1001"),
      of('A' + 0, "1010"),
      of('B' + 0, "1011"),
      of('C' + 0, "1100"),
      of('D' + 0, "1101"),
      of('E' + 0, "1110"),
      of('F' + 0, "1111"));

}
