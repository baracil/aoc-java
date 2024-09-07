package fpc.aoc.year2015.day4;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public abstract class Day4Solver extends SmartSolver<String> {

  @Override
  protected @NonNull Converter<String> getConverter() {
    return Converter.FIRST_LINE;
  }

  @SneakyThrows
  protected int solve(String input, int mask) {
    final var inputAsByte = input.getBytes(StandardCharsets.US_ASCII);
    final var md = MessageDigest.getInstance("MD5");

    final var buffer = new byte[16];

    for (int i = 0; ; i++) {
      md.update(inputAsByte);
      md.update(("" + i).getBytes(StandardCharsets.US_ASCII));
      md.digest(buffer, 0, buffer.length);

      if (buffer[0] == 0 && buffer[1] == 0 && (buffer[2] & mask) == 0) {
        return i;
      }
    }

  }

}
