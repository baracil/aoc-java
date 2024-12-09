package fpc.aoc.year2024.day09;

import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class BlockNode {

  private int index;
  private Block block;
  private @Nullable BlockNode previous;
  private @Nullable BlockNode next;

  public BlockNode(Block block) {
    this.block = block;
  }

  public void setIndex(int index) {
    this.index = index;
    if (this.next != null) {
      this.next.setIndex(this.index + 1);
    }
  }

  public void updateBlock(Block block) {
    this.block = block;
  }

  public BlockNode insertBefore(Block block) {
    final var node = new BlockNode(block);
    if (previous != null) {
      this.previous.next = node;
    }
    node.previous = this.previous;
    node.next = this;
    this.previous = node;
    node.setIndex(this.index);
    return node;
  }

  public BlockNode insertAfter(Block block) {
    final var node = new BlockNode(block);
    if (next != null) {
      this.next.previous = node;
    }
    node.next = this.next;
    node.previous = this;
    this.next = node;
    node.setIndex(this.index + 1);
    return node;
  }


  public String toString() {
    return block.toString();
  }

  public int size() {
    return block.size();
  }

  public long checksum(int pos) {
    final var size = block.size();
    if (block.type() == BlockType.FILE) {
      final var id = block.id();
      return ((size * (size + 1L)) / 2 + size * (pos - 1L)) * id;
    } else {
      return 0;
    }

  }
}
