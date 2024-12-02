package fpc.aoc.year2019.day23._private.packet;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Bastien Aracil
 **/
@Getter
@RequiredArgsConstructor
public class AddressPacket implements Packet {

    @NonNull
    public static AddressPacket create(int networkAddress) {
        return new AddressPacket(networkAddress);
    }

    private final int networkAddress;

    @NonNull
    @Override
    public <T> T accept(PacketVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
