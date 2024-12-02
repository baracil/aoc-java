package fpc.aoc.year2022.day7;

import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public class FileSystem {

  private final File.Folder root;

  public Stream<File.Folder> streamDirectories() {
    return Stream.concat(Stream.of(root), root.streamDirectories());
  }

  public int getFreeSpace() {
    int diskSize = 70000000;
    return diskSize - root.size();
  }
}
