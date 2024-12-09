package fpc.aoc.year2024.day09;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Day9Solver extends SmartSolver<Disk> {

  @Override
  protected Converter<Disk> getConverter() {
    return Converter.FIRST_LINE.andThen(this::toBlockNode);
  }

  private Disk toBlockNode(String diskMap) {
    BlockNode current = null;
    BlockNode first = null;
    for (int i = 0; i < diskMap.length(); i++) {
      final Block block;
      final var size = diskMap.charAt(i) - '0';
      if ((i % 2) == 0) {
        block = new Block(BlockType.FILE,size,i / 2);
      } else if (size != 0) {
        block = new Block(BlockType.SPACE,size,-1);
      } else {
        block = null;
      }
      if (block == null) {
        continue;
      }
      if (current == null) {
        first = new BlockNode(block);
        current = first;
      } else {
        current = current.insertAfter(block);
      }
    }
    return new Disk(first, current);
  }

}
