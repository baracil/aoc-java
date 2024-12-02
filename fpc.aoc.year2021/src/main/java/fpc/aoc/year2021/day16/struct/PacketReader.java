package fpc.aoc.year2021.day16.struct;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PacketReader {

  public static Packet read(String hexaPacket) {
    final var reader = Reader.fromHexaString(hexaPacket);
    return PacketReader.read(reader);
  }

  private static Packet read(Reader reader) {
    return new PacketReader(reader).read();
  }


  private final Reader reader;

  private Packet read() {
    final var version = reader.read(3);
    final var id = reader.read(3);

    return switch (id) {
      case 4 -> readLiteral(version, id);
      default -> readOperator(version, id);
    };
  }

  private Packet readLiteral(int version, int id) {
    var result = 0L;
    do {
      final var digit = reader.read(5);
      final var value = digit & 0b1111;
      result = result * 16L + value;

      if (value == digit) {
        return new Packet.Literal(version, result);
      }

    } while (true);
  }

  private Packet readOperator(int version, int id) {
    final var lengthTypeId = reader.read(1);
    final List<Packet> subPackets = new ArrayList<>();
    if (lengthTypeId == 0) {
      final var length = reader.read(15);
      final var subReader = reader.extract(length);
      while (subReader.remaining() > 6) {
        subPackets.add(PacketReader.read(subReader));
      }
    } else {
      final var nbPackets = reader.read(11);
      for (int i = 0; i < nbPackets; i++) {
        subPackets.add(PacketReader.read(reader));
      }
    }

    return new Packet.Operator(version, id, subPackets);
  }

}
