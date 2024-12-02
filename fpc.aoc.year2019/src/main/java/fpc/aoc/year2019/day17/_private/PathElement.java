package fpc.aoc.year2019.day17._private;

import fpc.aoc.common.Command;
import lombok.NonNull;
import lombok.Value;

import java.util.stream.Stream;

@Value
public class PathElement {

  Command command;

  int displacement;

  @NonNull
  public Stream<String> stream() {
    return Stream.of(command.code(), String.valueOf(displacement));
  }


}
