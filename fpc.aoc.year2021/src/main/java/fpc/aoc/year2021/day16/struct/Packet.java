package fpc.aoc.year2021.day16.struct;


import java.util.List;

public sealed interface Packet {

  record Literal(int version, long value) implements Packet {
    @Override
    public long sumOfVersions() {
      return version;
    }
  }

  record Operator(int version, int id, List<Packet> subPackets) implements Packet {
    @Override
    public long sumOfVersions() {
      return version + subPackets.stream().mapToLong(Packet::sumOfVersions).sum();
    }

    @Override
    public long value() {
      return switch (id) {
        case 0 -> subPackets.stream().mapToLong(Packet::value).sum();
        case 1 -> subPackets.stream().mapToLong(Packet::value).reduce(1, (a, b) -> a * b);
        case 2 -> subPackets.stream().mapToLong(Packet::value).min().orElseThrow();
        case 3 -> subPackets.stream().mapToLong(Packet::value).max().orElseThrow();
        case 5 -> subPackets.get(0).value() > subPackets.get(1).value() ? 1 : 0;
        case 6 -> subPackets.get(0).value() < subPackets.get(1).value() ? 1 : 0;
        case 7 -> subPackets.get(0).value() == subPackets.get(1).value() ? 1 : 0;
        default -> throw new UnsupportedOperationException();
      };
    }
  }


  long sumOfVersions();

  long value();
}
