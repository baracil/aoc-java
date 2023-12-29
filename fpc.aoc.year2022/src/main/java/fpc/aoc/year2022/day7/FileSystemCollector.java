package fpc.aoc.year2022.day7;

import lombok.NonNull;

import java.util.stream.Collector;

public class FileSystemCollector {

  public static final Collector<String, FileSystemCollector,FileSystem> COLLECTOR = Collector.of(
      FileSystemCollector::new,
      FileSystemCollector::handle,
      FileSystemCollector::combine,
      FileSystemCollector::build
  );

  private final File.Folder root = new File.Folder();
  private File current;

  public FileSystemCollector() {
    this.current = root;
  }

  public void handle(@NonNull String line) {
    if (line.startsWith("$")) {
      this.handleCommand(line);
    } else {
      this.handleLsOutput(line);
    }
  }

  public FileSystemCollector combine(@NonNull FileSystemCollector aggregator) {
    throw new IllegalStateException("Cannot aggregate in parallel");
  }

  public @NonNull FileSystem build() {
    return new FileSystem(root);
  }

  private void handleCommand(String line) {
    current = Command.parse(line).apply(current);
  }

  private void handleLsOutput(String line) {
    final var tokens = line.split(" ",2);
    if ("dir".equals(tokens[0])) {
      current.addFolder(tokens[1]);
    } else {
      current.addRegularFile(Integer.parseInt(tokens[0]),tokens[1]);
    }
  }

}
