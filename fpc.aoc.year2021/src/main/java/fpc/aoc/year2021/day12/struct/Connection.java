package fpc.aoc.year2021.day12.struct;

public record Connection(Node node1, Node node2) {

  public static Connection parse(String connection) {
    final var tokens = connection.split("-");

    return new Connection(Node.create(tokens[0]), Node.create(tokens[1]));
  }

}
