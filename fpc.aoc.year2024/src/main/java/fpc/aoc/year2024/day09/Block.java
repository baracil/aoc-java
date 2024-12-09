package fpc.aoc.year2024.day09;

import fpc.aoc.common.AOCException;
import lombok.Value;

@Value
public class Block {

  BlockType type;
  int size;
  int id;

  public String toString() {
    final var str = switch (type) {
      case FILE -> "" + id;
      case SPACE -> ".";
    };
    return str.repeat(size);
  }

  public Block withSizeReduced(int size) {
    if (this.size < size) {
      throw new AOCException("Cannot remove that much space");
    }
    return new Block(type, this.size - size, id);
  }

  public Block withSize(int size) {
    return new Block(this.type, size, id);
  }
}
