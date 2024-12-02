package fpc.aoc.year2019.day23._private.packet;

import lombok.NonNull;

/**
 * @author Bastien Aracil
 **/
public interface PacketVisitor<T> {

    @NonNull
    T visit(AddressPacket addressPacket);

    @NonNull
    T visit(DataPacket dataPacket);
}
