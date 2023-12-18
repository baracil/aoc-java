package fpc.aoc.day18.model;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Orientation;

public class InstructionParserPart2 implements InstructionParser {

  @Override
  public Instruction parse(String line) {
    final var token = line.split(" +")[2];
    final var value = Integer.parseInt(token.substring(2, token.length() - 1), 16);

    final var length = value / 16;
    final var type = value & 0xf;

    final var orientation = switch (type) {
      case 0 -> Orientation.E;
      case 2 -> Orientation.W;
      case 3 -> Orientation.N;
      case 1 -> Orientation.S;
      default -> throw new AOCException("Cannot parse orientation from '" + token + "'");
    };
    return new Instruction(orientation, length);

  }
}
