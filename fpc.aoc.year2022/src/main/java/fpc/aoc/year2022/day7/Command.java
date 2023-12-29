package fpc.aoc.year2022.day7;

import fpc.aoc.common.AOCException;
import lombok.NonNull;

public sealed interface Command permits Command.Cd, Command.Ls {

  @NonNull File apply(@NonNull File current);


  record Cd(@NonNull String folderName) implements Command {
    @Override
    public @NonNull File apply(@NonNull File current) {
      return switch (folderName) {
        case "/" -> current.root();
        case ".." -> current.parent();
        default ->
            current.findChild(folderName).orElseThrow(() -> new AOCException("Could find file '" + folderName + "' in folder '" + current.name() + "'"));
      };
    }
  }


  record Ls() implements Command {
    @Override
    public @NonNull File apply(@NonNull File current) {
      return current;
    }
  }


  static @NonNull Command parse(@NonNull String line) {
    if (line.charAt(0) != '$') {
      throw new AOCException("Invalid line '" + line + "' for command");
    }
    if (line.equals("$ ls")) {
      return new Ls();
    }
    final int idx = line.indexOf(" ", 3);
    final var path = line.substring(idx + 1);
    return new Cd(path);
  }

}
