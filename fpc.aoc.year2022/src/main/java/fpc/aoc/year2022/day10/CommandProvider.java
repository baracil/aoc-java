package fpc.aoc.year2022.day10;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CommandProvider {

  private final List<Command> commands;

  private int commandIndex = 0;

  public Optional<Command> takeCommand() {
    if (commandIndex >= commands.size()) {
      return Optional.empty();
    }
    return Optional.ofNullable(commands.get(commandIndex++));
  }

}
