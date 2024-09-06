package fpc.aoc.year2019.day23._private.packet;

import lombok.NonNull;

/**
 * @author perococco
 **/
public interface PacketVisitor<T> {

    @NonNull
    T visit(@NonNull AddressPacket addressPacket);

    @NonNull
    T visit(@NonNull DataPacket dataPacket);
}
