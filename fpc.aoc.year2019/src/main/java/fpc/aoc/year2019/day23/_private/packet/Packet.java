package fpc.aoc.year2019.day23._private.packet;

import lombok.NonNull;

/**
 * @author Bastien Aracil
 **/
public interface Packet {

    @NonNull
    <T> T accept(@NonNull PacketVisitor<T> visitor);
}
