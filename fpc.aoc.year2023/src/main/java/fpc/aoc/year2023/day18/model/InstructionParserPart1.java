package fpc.aoc.year2023.day18.model;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Orientation;

public class InstructionParserPart1 implements InstructionParser {

  @Override
  public Instruction parse(String line) {
    final var tokens = line.split(" +");

    final var orientation = switch (tokens[0]) {
      case "R" -> Orientation.E;
      case "L" -> Orientation.W;
      case "U" -> Orientation.N;
      case "D" -> Orientation.S;
      default -> throw new AOCException("Cannot parse orientation from '"+tokens[0]+"'");
    };
    final var length = Integer.parseInt(tokens[1]);

    return new Instruction(orientation,length);

  }
}
