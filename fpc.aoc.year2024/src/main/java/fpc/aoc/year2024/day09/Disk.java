package fpc.aoc.year2024.day09;

import fpc.aoc.common.AOCException;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class Disk {
  private final BlockNode first;
  private final BlockNode last;

  public String display() {
    return Stream.iterate(this.first, Objects::nonNull, BlockNode::next)
        .map(BlockNode::toString)
        .collect(Collectors.joining());
  }

  public void compactPart2() {
    var fileNode = findFile(last);
    while (fileNode != null) {
      final var size = fileNode.size();
      final var spaceNode = findSpaceBigEnough(size, fileNode.index());
      if (spaceNode != null) {
        final var fileBlock = fileNode.block();
        final var spaceBlock = spaceNode.block();
        final var fileSize = fileNode.size();
        final var spaceSize = spaceNode.size();
        if (fileSize == spaceSize) {
          spaceNode.updateBlock(fileBlock);
          fileNode.updateBlock(spaceBlock);
        } else {
          spaceNode.insertBefore(fileBlock);
          spaceNode.updateBlock(spaceBlock.withSizeReduced(fileSize));
          fileNode.updateBlock(spaceBlock.withSize(fileSize));
        }
        fileNode = findFile(fileNode);
      } else {
        fileNode = findFile(fileNode.previous());
      }
    }

  }

  private BlockNode findSpaceBigEnough(int size, int index) {
    var current = first;
    while (current != null && current.index() < index) {
      if (current.size() >= size && current.block().type() == BlockType.SPACE) {
        return current;
      }
      current = current.next();
    }
    return null;
  }

  public void compactPart1() {
    var spaceNode = findSpace(first);
    var fileNode = findFile(last);
    if (spaceNode == null || fileNode == null) {
      throw new AOCException("Something wrong, no space or no file available");
    }
    while (spaceNode != null && fileNode != null && spaceNode.index() < fileNode.index()) {
      final var fileBlock = fileNode.block();
      final var spaceBlock = spaceNode.block();
      final var spaceSize = spaceNode.size();
      final var fileSize = fileNode.size();
      if (spaceSize > fileSize) {
        spaceNode.insertBefore(fileBlock);
        spaceNode.updateBlock(spaceBlock.withSizeReduced(fileSize));
        fileNode.updateBlock(spaceBlock.withSize(fileSize));
        fileNode = findFile(fileNode);
      } else if (spaceSize < fileSize) {
        spaceNode.updateBlock(fileBlock.withSize(spaceSize));
        fileNode.updateBlock(fileBlock.withSizeReduced(spaceSize));
        fileNode.insertAfter(spaceBlock);
        spaceNode = findSpace(spaceNode);
      } else {
        spaceNode.updateBlock(fileBlock);
        fileNode.updateBlock(spaceBlock);
        fileNode = findFile(fileNode);
        spaceNode = findSpace(spaceNode);
      }
    }
  }

  public long computeChecksum() {
    long result = 0;
    int pos = 0;
    var current = first;
    while (current != null) {
      result += current.checksum(pos);
      pos += current.size();
      current = current.next();
    }
    return result;
  }

  private BlockNode findSpace(BlockNode node) {
    while (node != null) {
      if (node.block().type() == BlockType.SPACE) {
        return node;
      }
      node = node.next();
    }
    return null;
  }

  private BlockNode findFile(BlockNode node) {
    while (node != null) {
      if (node.block().type() == BlockType.FILE) {
        return node;
      }
      node = node.previous();
    }
    return null;
  }

}