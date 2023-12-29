package fpc.aoc.year2021.day12.struct;

import lombok.NonNull;

public record Connection(@NonNull Node node1, @NonNull Node node2) {

  public static @NonNull Connection parse(@NonNull String connection) {
    final var tokens = connection.split("-");

    return new Connection(Node.create(tokens[0]), Node.create(tokens[1]));
  }

}
