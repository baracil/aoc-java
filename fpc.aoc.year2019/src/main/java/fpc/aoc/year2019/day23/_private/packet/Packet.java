package fpc.aoc.year2019.day23._private.packet;

import lombok.NonNull;

/**
 * @author perococco
 **/
public interface Packet {

    @NonNull
    <T> T accept(@NonNull PacketVisitor<T> visitor);
}
