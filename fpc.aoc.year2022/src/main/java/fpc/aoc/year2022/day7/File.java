package fpc.aoc.year2022.day7;

import fpc.aoc.common.AOCException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public sealed interface File permits File.Folder, File.RegularFile {

  Folder root();

  Folder parent();

  String name();

  Optional<File> findChild(String folderName);

  void addFolder(String token);

  void addRegularFile(int parseInt, String token);


  @RequiredArgsConstructor
  @Getter
  final class Folder implements File {
    private final String name;
    private final Folder root;
    private final Folder parent;
    private final List<File> children = new ArrayList<>();
    private int size = 0;

    public Folder() {
      this.name = "/";
      this.root = this;
      this.parent = this;
    }

    public Stream<Folder> streamDirectories() {
      return children.stream().filter(f -> f instanceof Folder)
          .map(f -> (Folder) f)
          .flatMap(folder -> Stream.concat(Stream.of(folder), folder.streamDirectories()));
    }

    @Override
    public Optional<File> findChild(String folderName) {
      return children.stream().filter(c -> c.name().equals(folderName)).findAny();
    }

    @Override
    public void addFolder(String name) {
      this.children.add(new Folder(name, root, this));
    }

    @Override
    public void addRegularFile(int size, String name) {
      this.children.add(new RegularFile(name, size, root, this));
      this.addToSize(size);
    }

    public void addToSize(int size) {
      this.size += size;
      if (this.parent != this) {
        this.parent.addToSize(size);
      }
    }

    @Override
    public String toString() {
      return "dir : " + name + " " + size;
    }
  }

  @Value
  class RegularFile implements File {
    String name;
    int size;
    Folder root;
    Folder parent;

    public Optional<File> findChild(String folderName) {
      return Optional.empty();
    }

    @Override
    public void addFolder(String token) {
      throw new AOCException("Cannot add child to a regular file");
    }

    @Override
    public void addRegularFile(int parseInt, String token) {
      throw new AOCException("Cannot add child to a regular file");
    }

    @Override
    public String toString() {
      return "fil : " + name + " " + size;
    }

  }
}
