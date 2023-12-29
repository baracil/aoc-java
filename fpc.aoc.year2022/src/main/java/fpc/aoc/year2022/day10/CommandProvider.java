package fpc.aoc.year2022.day10;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CommandProvider {

  private final @NonNull List<Command> commands;

  private int commandIndex = 0;

  public @NonNull Optional<Command> takeCommand() {
    if (commandIndex >= commands.size()) {
      return Optional.empty();
    }
    return Optional.ofNullable(commands.get(commandIndex++));
  }

}
